package Sbchalet.demo.services;

import java.util.List;
import java.util.Optional;

import Sbchalet.demo.models.Reservation;

public interface IReservationService {

	List<Reservation> list();

	Reservation save(Reservation res);

	void remove(int idResarvation);

	Reservation updateReservation(int idResarvation, Reservation reservation);

	Optional<Reservation> getById(int idResarvation);
	
}
