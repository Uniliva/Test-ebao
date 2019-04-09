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
import br.com.uniliva.ebao.repository.BillRepository;

@Service
public class BillService {
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	AdjustmentRepository adjustmentRepository;

	public List<br.com.uniliva.ebao.dto.BillDto> findAll() {
		List<Adjustment> adjustments = adjustmentRepository.findAll();

		List<BillDto> billDtos = new ArrayList<BillDto>();
		for (Adjustment adj : adjustments) {
			BillDto dto = new BillDto(adj.getBill().getId(), adj.getBill().getCreateDate(), adj.getBill().getAmount(), adj.getBill().getDueDate()).addAdjustment(adj.getId(), adj.getStatus(), adj.getCreateDate());
			billDtos.add(dto);
		}
		
		return billDtos;
	}
	
	public List<br.com.uniliva.ebao.dto.BillDto> findByFilter(FilterDto filter) {
		List<BillDto> billDtos = new ArrayList<BillDto>();
		List<Adjustment> adjustments;
		
		if(filter.getStatus().equals("ALL") && filter.getDate().isEmpty()) {
			billDtos = this.findAll();
		}else if(filter.getDate().isEmpty()) {
			adjustments = adjustmentRepository.findByStatus(Status.valueOf(filter.getStatus().toUpperCase()));
			for (Adjustment adj : adjustments) {
				BillDto dto = new BillDto(adj.getBill().getId(), adj.getBill().getCreateDate(), adj.getBill().getAmount(), adj.getBill().getDueDate()).addAdjustment(adj.getId(), adj.getStatus(), adj.getCreateDate());
				billDtos.add(dto);
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
