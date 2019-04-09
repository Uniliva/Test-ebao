package br.com.uniliva.ebao.resource;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.uniliva.ebao.enums.Status;
import br.com.uniliva.ebao.service.BillService;

@Controller
public class BillResource {
	@Autowired
	BillService service;
	
	@GetMapping("/all")
	public List<br.com.uniliva.ebao.dto.BillDto> findAll() {
		return service.findAll();
	}	
	
	@GetMapping("/status/{status}")
	public List<br.com.uniliva.ebao.dto.BillDto> findByStatus(@PathVariable Status status) {
		return service.findByStatus(status);
	}
	
	@GetMapping("/date/{date}")
	public List<br.com.uniliva.ebao.dto.BillDto> findByCreateDate(@PathVariable Date date) {
		return service.findByCreateDate(date);
	}

}
