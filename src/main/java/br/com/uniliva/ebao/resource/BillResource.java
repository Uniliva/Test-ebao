package br.com.uniliva.ebao.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import br.com.uniliva.ebao.dto.BillDto;
import br.com.uniliva.ebao.dto.FilterDto;
import br.com.uniliva.ebao.service.BillService;

@Controller
public class BillResource {
	@Autowired
	private BillService service;
	
	
	private List<String> statusOptions = new ArrayList<String>(Arrays.asList("TODOS","ATIVO","CANCELADO"));
	
	@GetMapping("/boletos")
	public String getBills(@ModelAttribute FilterDto filter, Model model) {
		List<BillDto> bills = new ArrayList<BillDto>();
		if(filter.getStatus() == null) {
			filter = new FilterDto("TODOS","");
		}
			bills = service.findByFilter(filter);
		model.addAttribute("bills", bills);
		model.addAttribute("filterDto", filter);
		model.addAttribute("statusOptions", this.statusOptions);
		model.addAttribute("filtroStatus", filter.getStatus());
		return "index";
	}
	
	@GetMapping("/boletos-v2")
	public String getMapBills(@ModelAttribute FilterDto filter, Model model) {
		Map<Long, List<BillDto>> mapBill = new HashMap<Long,List<BillDto>>();
		if(filter.getStatus() == null) {
			filter = new FilterDto("TODOS","");
		}
		mapBill = service.getMapBill(filter);
		System.out.println("Uniliva"+mapBill);
		model.addAttribute("mapBill", mapBill);
		model.addAttribute("filterDto", filter);
		model.addAttribute("statusOptions", this.statusOptions);
		model.addAttribute("filtroStatus", filter.getStatus());
		return "index2";
	}

}
