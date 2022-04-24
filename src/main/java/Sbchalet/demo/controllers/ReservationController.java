package Sbchalet.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Sbchalet.demo.models.Reservation;
import Sbchalet.demo.services.IReservationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/reservation")
public class ReservationController {

	private IReservationService reservationService;
//	private UserRepository userRepository;

	@Autowired
	public void setPostservice(IReservationService reservationService) {
		this.reservationService = reservationService;
	}

	//@Autowired
	//public void setUserDetailService(UserRepository userRepository) {
		//this.userRepository = userRepository;
//	}

	// getPost => afficher les posts
	@GetMapping("")
	public List<Reservation> getAllPost() {
		return this.reservationService.list();
	}

	// getreservation by id
	@GetMapping("/{reservation-id}")
	@ResponseBody
	public Optional<Reservation> retrieveResarvation(@PathVariable("reservation-id") int idResarvation) {
		return this.reservationService.getById(idResarvation);
	}

	// ajouter post
	@PostMapping("")
	@ResponseBody
	public Reservation addReservation(@RequestBody Reservation res) throws Exception {
		
		
		Reservation reservation = reservationService.save(res);
		return reservation;
	}
 
	// supprimer post
	@DeleteMapping("/{idResarvation}")
	@ResponseBody
	public void removeReservation(@PathVariable("idResarvation") int idResarvation) {
		reservationService.remove(idResarvation);
	}

	// mis a jour resaervation
	@PutMapping("/{idResarvation}")
	@ResponseBody
	public Reservation modifyReservation(@PathVariable int idResarvation, @RequestBody Reservation reservation) {
		return reservationService.updateReservation(idResarvation, reservation);
	}

}