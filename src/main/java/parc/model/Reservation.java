package parc.model;

import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="réservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate dateReservation;
	private LocalDate dateFinReservation;
	private double prixTotal;
	
	
<<<<<<< HEAD
	@JoinColumn(name="client")
	@OneToOne
	private Client client;
	
	
	@JoinColumn(name="visiteur")
	@ManyToOne
	private Visiteur visiteur;
	
	
	
=======
>>>>>>> classes_attractions
}
