package Sbchalet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Sbchalet.demo.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Integer>{

}
