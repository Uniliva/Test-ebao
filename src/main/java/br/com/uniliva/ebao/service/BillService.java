package br.com.uniliva.ebao.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uniliva.ebao.dto.BillDto;
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
	
	public List<br.com.uniliva.ebao.dto.BillDto> findByStatus(Status status) {
		List<Adjustment> adjustments = adjustmentRepository.findByStatus(status.getDescricao());
		
		List<BillDto> billDtos = new ArrayList<BillDto>();
		for (Adjustment adj : adjustments) {
			BillDto dto = new BillDto(adj.getBill().getId(), adj.getBill().getCreateDate(), adj.getBill().getAmount(), adj.getBill().getDueDate()).addAdjustment(adj.getId(), adj.getStatus(), adj.getCreateDate());
			billDtos.add(dto);
		}
		
		return billDtos;
	}
	
	public List<br.com.uniliva.ebao.dto.BillDto> findByCreateDate(Date date) {
		List<Adjustment> adjustments = adjustmentRepository.findByCreateDate(date);
		
		List<BillDto> billDtos = new ArrayList<BillDto>();
		for (Adjustment adj : adjustments) {
			BillDto dto = new BillDto(adj.getBill().getId(), adj.getBill().getCreateDate(), adj.getBill().getAmount(), adj.getBill().getDueDate()).addAdjustment(adj.getId(), adj.getStatus(), adj.getCreateDate());
			billDtos.add(dto);
		}
		
		return billDtos;
	}


}
