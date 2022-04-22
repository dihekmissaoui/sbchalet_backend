package Sbchalet.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sbchalet.demo.models.Reservation;
import Sbchalet.demo.repository.ReservationRepository;

@Service
public class IReservationServiceImpl implements IReservationService{

	@Autowired
	ReservationRepository reservationRepository ;
	@Override
	public List<Reservation> list() {
		return (List<Reservation>) this.reservationRepository.findAll();
	}

	@Override
	public Reservation save(Reservation res) {
		return this.reservationRepository.save(res);
	}

	@Override
	public void remove(int idResarvation) {
		this.reservationRepository.deleteById(idResarvation);


	}

	@Override
	public Reservation updateReservation(int idResarvation, Reservation reservation) {
		Reservation updatedpost = null;
		Optional<Reservation> searchReservation = reservationRepository.findById(idResarvation);
		if (searchReservation.isPresent()) {
			Reservation finded = searchReservation.get();
			finded = reservation;
			updatedpost = this.reservationRepository.save(finded);
		}
		return updatedpost;
	}

	@Override
	public Optional<Reservation> getById(int idResarvation) {
		return this.reservationRepository.findById(idResarvation);
	}

}
