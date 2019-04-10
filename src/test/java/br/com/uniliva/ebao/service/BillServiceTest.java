package br.com.uniliva.ebao.service;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.uniliva.ebao.dto.BillDto;
import br.com.uniliva.ebao.dto.FilterDto;
import br.com.uniliva.ebao.entity.Adjustment;
import br.com.uniliva.ebao.entity.Bill;
import br.com.uniliva.ebao.enums.Status;
import br.com.uniliva.ebao.repository.AdjustmentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillServiceTest {
	@Autowired
	AdjustmentRepository adjustmentRepository;
	
	@Autowired
	private BillService sevice;
	
	@Test
	public void findByFilterTest() throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		Bill bill = new Bill(formatter.parse("01-01-1999"), 100, formatter.parse("05-01-1999"));
		Adjustment adjustment = new Adjustment(bill, Status.ATIVO, formatter.parse("03-01-1999"));
		adjustmentRepository.save(adjustment);
		
		Bill bill2 = new Bill(formatter.parse("01-01-1999"), 100, formatter.parse("05-01-1999"));
		Adjustment adjustment2 = new Adjustment(bill2, Status.CANCELADO, formatter.parse("03-01-1999"));
		adjustmentRepository.save(adjustment2);
		
		FilterDto  filter = new FilterDto("ATIVO","03-01-1999");

		List<BillDto> billDtos = sevice.findByFilter(filter);

		
		assertEquals(1, billDtos.size());
		assertEquals(adjustment.getStatus(), billDtos.get(0).getStatus());
		assertEquals(bill.getId(), billDtos.get(0).getId());

		
	}
	
	@After
	public void cleanDataBase () {
		adjustmentRepository.deleteAll();
	}
	

}
