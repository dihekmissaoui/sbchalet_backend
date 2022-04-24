package Sbchalet.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Sbchalet.demo.models.Reservation;
import Sbchalet.demo.repository.ReservationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class IReservationServiceImplTest {
	@Autowired
	ReservationRepository rep;

	@Test
	public void testlist() {

		List<Reservation> res = rep.findAll();
		Assertions.assertEquals(5, res.size());

	}
	
	@Test
	public void testgetById () {
		Reservation res = rep.getById(3);
	  Assertions.assertNotNull(res);
	}

}
