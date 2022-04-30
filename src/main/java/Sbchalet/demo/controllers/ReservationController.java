package Sbchalet.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.omg.CosNaming.NamingContextPackage.NotFound;
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

import Sbchalet.demo.constants.EmailConstants;
import Sbchalet.demo.models.Chalet;
import Sbchalet.demo.models.Reservation;
import Sbchalet.demo.models.User;
import Sbchalet.demo.payload.request.ReservationRequest;
import Sbchalet.demo.services.IChaletService;
import Sbchalet.demo.services.IEmailSenderService;
import Sbchalet.demo.services.IReservationService;
import Sbchalet.demo.services.IUserservice;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/reservation")
public class ReservationController {

	private IReservationService reservationService;
	private IChaletService chaletService;
	private IUserservice userService;
	private IEmailSenderService emailSenderService;

	@Autowired
	public void setReservationService(IReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@Autowired
	public void setChaletService(IChaletService chaletService) {
		this.chaletService = chaletService;
	}

	@Autowired
	public void setUserService(IUserservice userService) {
		this.userService = userService;
	}

	@Autowired
	public void setEmailSenderService(IEmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}

	@GetMapping("")
	public List<Reservation> getAllPost() {
		return this.reservationService.list();
	}

	@GetMapping("/{reservation-id}")
	@ResponseBody
	public Optional<Reservation> retrieveResarvation(@PathVariable("reservation-id") int idResarvation) {
		return this.reservationService.getById(idResarvation);
	}

	@PostMapping("")
	@ResponseBody
	public Reservation addReservation(@RequestBody ReservationRequest reservationRequest) throws Exception {
		Optional<Chalet> optionalData = this.chaletService.getById(reservationRequest.getChalet());
		Reservation reservation = null;
		if (!optionalData.isPresent()) {
			throw new NotFound("Veuillez reéssayer ultérieurement", null, null);
		} else {
			Chalet chalet = optionalData.get();
			User user = this.generateUser(reservationRequest);

			reservation = new Reservation();
			Reservation payload = new Reservation(reservationRequest.getDateDeDebut(),
					reservationRequest.getDateDeDefin(), new Float(reservationRequest.getNbNuites()),
					new Float(reservationRequest.getTotalPrix()), chalet, user);

			reservation = reservationService.save(payload);
			
			this.emailSenderService.sendEmail(user.getEmail(), EmailConstants.EMAIL_RESERVATION_SUBJECT,
					EmailConstants.EMAIL_RESERVATION_BODY);
		}
		return reservation;
	}

	private User generateUser(ReservationRequest reservationRequest) {
		String userName = reservationRequest.getUser().getUsername();
		String nom = reservationRequest.getUser().getNom();
		String prenom = reservationRequest.getUser().getPrenom();
		String email = reservationRequest.getUser().getEmail();
		String password = reservationRequest.getUser().getPassword();

		User user = new User(userName, nom, prenom, email, password);

		return this.userService.saveUser(user);
	}

	@DeleteMapping("/{idResarvation}")
	@ResponseBody
	public void removeReservation(@PathVariable("idResarvation") int idResarvation) {
		reservationService.remove(idResarvation);
	}

	@PutMapping("/{idResarvation}")
	@ResponseBody
	public Reservation modifyReservation(@PathVariable int idResarvation, @RequestBody Reservation reservation) {
		return reservationService.updateReservation(idResarvation, reservation);
	}

}
