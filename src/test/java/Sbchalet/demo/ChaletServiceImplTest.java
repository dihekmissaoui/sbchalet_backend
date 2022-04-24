package Sbchalet.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Sbchalet.demo.models.Chalet;
import Sbchalet.demo.repository.ChaletRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
class ChaletServiceImplTest {
	
	@Autowired
	ChaletRepository rep ;
	
	
	public void testlist() throws Exception {
		List<Chalet> chalet = rep.findAll();
		System.out.println(chalet);
		Assertions.assertEquals(8, chalet.size());
		
	}
	
//	@Test
	public void testupdateChalet () {
		
		Chalet ch = new Chalet();
		//ch.setId_chalet(20);
//		ch.setDescription("villa");
//		ch.setNom("chalet");
//		ch.setPrix(10);
//		Chalet ch2 = rep.save(ch);
//		Assertions.assertEquals(ch.getDescription(), ch2.getDescription());

	}
	

	

}
