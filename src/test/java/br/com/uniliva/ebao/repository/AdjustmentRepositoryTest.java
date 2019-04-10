package br.com.uniliva.ebao.repository;

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

import br.com.uniliva.ebao.entity.Adjustment;
import br.com.uniliva.ebao.entity.Bill;
import br.com.uniliva.ebao.enums.Status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdjustmentRepositoryTest {
	@Autowired
	private AdjustmentRepository adjustmentRepository;

	@Test
	public void findByCreateDateTest() throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		Bill bill = new Bill(formatter.parse("01-01-1999"), 100, formatter.parse("05-01-1999"));

		Adjustment adjustment = new Adjustment(bill, Status.ATIVO, formatter.parse("01-01-1999"));
		adjustmentRepository.save(adjustment);

		List<Adjustment> adjustments = adjustmentRepository.findByCreateDate(formatter.parse("01-01-1999"));

		assertEquals(1, adjustments.size());
		assertEquals(adjustment.getStatus(), adjustments.get(0).getStatus());
		assertEquals(bill.getId(), adjustments.get(0).getBill().getId());
	}

	@Test
	public void findByStatusTest() throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		Bill bill = new Bill(formatter.parse("01-01-1999"), 100, formatter.parse("05-01-1999"));

		Adjustment adjustment = new Adjustment(bill, Status.ATIVO, formatter.parse("01-01-1999"));
		adjustmentRepository.save(adjustment);

		List<Adjustment> adjustments = adjustmentRepository.findByStatus(Status.ATIVO);

		assertEquals(1, adjustments.size());
		assertEquals(adjustment.getStatus(), adjustments.get(0).getStatus());
		assertEquals(bill.getId(), adjustments.get(0).getBill().getId());

	}
	
	@Test
	public void findByFiltersTest() throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		Bill bill = new Bill(formatter.parse("01-01-1999"), 100, formatter.parse("05-01-1999"));

		Adjustment adjustment = new Adjustment(bill, Status.ATIVO, formatter.parse("03-01-1999"));
		adjustmentRepository.save(adjustment);
		
		Bill bill2 = new Bill(formatter.parse("01-01-1999"), 100, formatter.parse("05-01-1999"));

		Adjustment adjustment2 = new Adjustment(bill2, Status.CANCELADO, formatter.parse("03-01-1999"));
		adjustmentRepository.save(adjustment2);

		List<Adjustment> adjustments = adjustmentRepository.findByFilters(Status.ATIVO,formatter.parse("03-01-1999"));

		List<Adjustment> adjustments2 = adjustmentRepository.findAll();
		
		assertEquals(1, adjustments.size());
		assertEquals(2, adjustments2.size());
		assertEquals(adjustment.getStatus(), adjustments.get(0).getStatus());
		assertEquals(bill.getId(), adjustments.get(0).getBill().getId());

	}
	
	
	@After
	public void cleanDataBase () {
		adjustmentRepository.deleteAll();
	}

}
