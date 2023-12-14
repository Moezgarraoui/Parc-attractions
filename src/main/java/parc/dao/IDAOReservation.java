package parc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import parc.model.Reservation;


public interface IDAOReservation extends JpaRepository <Reservation,Integer> {

}
