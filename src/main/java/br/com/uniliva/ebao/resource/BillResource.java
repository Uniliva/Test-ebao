package br.com.uniliva.ebao.resource;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import br.com.uniliva.ebao.dto.BillDto;
import br.com.uniliva.ebao.service.BillService;

@Controller
public class BillResource {
	@Autowired
	BillService service;
	
	@GetMapping("/all")
	 public String getAll(Model model) {
		List<BillDto> bills = service.findAll();
		model.addAttribute("bills", bills);
		return "index";
	}	
	
	@GetMapping("/status/{status}")
	public String getByStatus(@ModelAttribute String status, Model model) {
		/*List<BillDto> bills = service.findByStatus(Status.ATIVO);
		model.addAttribute("bills", bills);*/
		return "index";
	}
	
	@GetMapping("/date/{date}")
	 public String getByCreateDate(@ModelAttribute Date date,Model model) {
		List<BillDto> bills = service.findByCreateDate(date);
		model.addAttribute("bills", bills);
		return "index";
	}

}
