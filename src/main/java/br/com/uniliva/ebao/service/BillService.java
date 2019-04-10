package br.com.uniliva.ebao.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uniliva.ebao.dto.BillDto;
import br.com.uniliva.ebao.dto.FilterDto;
import br.com.uniliva.ebao.entity.Adjustment;
import br.com.uniliva.ebao.enums.Status;
import br.com.uniliva.ebao.repository.AdjustmentRepository;

@Service
public class BillService {	
	@Autowired
	private AdjustmentRepository adjustmentRepository;

	public List<br.com.uniliva.ebao.dto.BillDto> findByFilter(FilterDto filter) {
		List<BillDto> billDtos = new ArrayList<BillDto>();
		List<Adjustment> adjustments;
		
		if(filter.getStatus().equals("TODOS") && filter.getDate().isEmpty()) {
			adjustments = adjustmentRepository.findAll();
			for (Adjustment adj : adjustments) {
				BillDto dto = new BillDto(adj.getBill().getId(), adj.getBill().getCreateDate(), adj.getBill().getAmount(), adj.getBill().getDueDate()).addAdjustment(adj.getId(), adj.getStatus(), adj.getCreateDate());
				billDtos.add(dto);
			}
		}else if(filter.getDate().isEmpty()) {
			adjustments = adjustmentRepository.findByStatus(Status.valueOf(filter.getStatus().toUpperCase()));
			for (Adjustment adj : adjustments) {
				BillDto dto = new BillDto(adj.getBill().getId(), adj.getBill().getCreateDate(), adj.getBill().getAmount(), adj.getBill().getDueDate()).addAdjustment(adj.getId(), adj.getStatus(), adj.getCreateDate());
				billDtos.add(dto);
			}
		}else if( filter.getStatus().equals("TODOS") && !filter.getDate().isEmpty()) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			try {
				adjustments = adjustmentRepository.findByCreateDate(formatter.parse(filter.getDate()));
				for (Adjustment adj : adjustments) {
					BillDto dto = new BillDto(adj.getBill().getId(), adj.getBill().getCreateDate(), adj.getBill().getAmount(), adj.getBill().getDueDate()).addAdjustment(adj.getId(), adj.getStatus(), adj.getCreateDate());
					billDtos.add(dto);
				}
				
			} catch (ParseException e) {
				//lançar exceção
				return null;
			}
		}else {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			try {
				adjustments = adjustmentRepository.findByFilters(Status.valueOf(filter.getStatus().toUpperCase()), formatter.parse(filter.getDate()));
				for (Adjustment adj : adjustments) {
					BillDto dto = new BillDto(adj.getBill().getId(), adj.getBill().getCreateDate(), adj.getBill().getAmount(), adj.getBill().getDueDate()).addAdjustment(adj.getId(), adj.getStatus(), adj.getCreateDate());
					billDtos.add(dto);
				}
				
			} catch (ParseException e) {
				//lançar exceção
				return null;
			}
		}
		
		return billDtos;
		
		
	
	}


}
