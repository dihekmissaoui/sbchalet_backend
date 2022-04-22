package Sbchalet.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sbchalet.demo.models.Reservation;
import Sbchalet.demo.repository.ReservationRepository;

@Service
public class IReservationServiceImpl implements IReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	private static final Logger logger = Logger.getLogger(IReservationServiceImpl.class);

	@Override
	public List<Reservation> list() {
		try {
			logger.info(" Je suis dans ListReservation ");
			logger.debug("Je vais retourner ListReservation");
			logger.info("Je vien de finir l'operation ");
			return (List<Reservation>) this.reservationRepository.findAll();
		} catch (Exception e) {
			logger.error("Error in ListChalet() :", e);
		}
		return new ArrayList<Reservation>();

	}

	@Override
	public Reservation save(Reservation res) {
		try {
			logger.trace("accès à la méthode");
			logger.info("je vais enregister Reservation");
			return this.reservationRepository.save(res);

		} catch (Exception e) {
			logger.error("Error dans save() :", e);
		}
		return new Reservation();
	}

	@Override
	public void remove(int idResarvation) {
		try {
			logger.info("supprimer Reservation= " + idResarvation);
			this.reservationRepository.deleteById(idResarvation);
		} catch (Exception e) {
			logger.error("Error dans remove() :", e);
		}
		logger.info("Reservation n'existe pas");

	}

	@Override
	public Reservation updateReservation(int idResarvation, Reservation reservation) {
		try {
			logger.info("je suis dans updateReservation()");
			Reservation updatedpost = null;
			Optional<Reservation> searchReservation = reservationRepository.findById(idResarvation);
			if (searchReservation.isPresent()) {
				Reservation finded = searchReservation.get();
				finded = reservation;
				logger.debug("je vais lancer updateReservation ,");
				updatedpost = this.reservationRepository.save(finded);
			}
			logger.info("j'ai terminé mon instruction ");
			return updatedpost;

		} catch (Exception e) {
			logger.error("Error dans updateReservation :", e);
		}
		return new Reservation();

	}

	@Override
	public Optional<Reservation> getById(int idResarvation) {
		try {
			logger.info("je vais afficher le Chalet par id =" + idResarvation);
			return this.reservationRepository.findById(idResarvation);
		} catch (Exception e) {
			logger.error("Error dans getById() :", e);
		}
		return null ;
	}

}
