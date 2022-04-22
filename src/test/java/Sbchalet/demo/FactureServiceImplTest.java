package Sbchalet.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Sbchalet.demo.models.Facture;
import Sbchalet.demo.repository.FactureRepository;
import Sbchalet.demo.services.IFactureService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactureServiceImplTest {

	@Autowired
	private FactureRepository REP;

	@Test
	public void testList() throws Exception {
		List<Facture> fact = REP.findAll();
		Assertions.assertEquals(14, fact.size());
	}

	@Test
	public void testsave() {
		Facture fac = new Facture();
		fac.setDateFacture(new Date());
		fac.setMontant(28);
		fac.setIdResarvation(2);
		REP.save(fac);
		assertNotNull(fac.getIdResarvation());

	}

	@Test
	public void testupdateFacture() throws Exception {
		float mantontfact = 300;
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2022-03-02");
		Facture fact = new Facture(3, date, mantontfact, 2);//hetha eli nheb nzidu w ntasti bih  
		fact.setId_Facture(3);
		Facture f = REP.save(fact); // eli mawjud 3andi fel bd ba3ed mabdelt  eli houwa nafsou fact
		Assertions.assertEquals(fact.getMontant(), f.getMontant());

	}
	
	  @Test
	  public void testgetById() {
		Facture f = REP.getById(50);	
		Assertions.assertNotNull(50);
		  
		  
	  }

}
