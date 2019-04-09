package br.com.uniliva.ebao.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.uniliva.ebao.dto.BillDto;
import br.com.uniliva.ebao.dto.FilterDto;
import br.com.uniliva.ebao.service.BillService;

@Controller
public class BillResource {
	@Autowired
	BillService service;
	
	List<String> statusOptions = new ArrayList<String>(Arrays.asList("ALL","ATIVO","CANCELADO"));
	
	@GetMapping("/test")
	 public String getAll(Model model) {
		List<BillDto> bills = service.findAll();
		FilterDto filterDto = new FilterDto("ALL","");
		model.addAttribute("bills", bills);
		model.addAttribute("filterDto", filterDto);
		model.addAttribute("statusOptions", this.statusOptions);
		model.addAttribute("filtroStatus", filterDto.getStatus());
		return "index";
	}	
	
	@PostMapping("/filter")
	public String getByStatus(@ModelAttribute FilterDto filter, Model model) {
		
		List<BillDto> bills = service.findByFilter(filter);
		model.addAttribute("bills", bills);
		model.addAttribute("filterDto", filter);
		model.addAttribute("statusOptions", this.statusOptions);
		model.addAttribute("filtroStatus", filter.getStatus());
		return "index";
	}

}
