package parc.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "réservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private LocalDate dateReservation;
	@Column
	private LocalDate dateFinReservation;
	@Column
	private double prixTotal;

	@JoinColumn(name = "client")
	@OneToOne
	private Client client;

	@JoinColumn(name = "visiteur")
	@ManyToOne
	private Visiteur visiteur;
	@OneToOne
	@JoinColumn(name = "repas")
	private Repas repas;

	@OneToOne
	@JoinColumn(name = "hotel")
	private Hotel hotel;

	public Reservation() {
	}

	public Reservation(LocalDate dateReservation, LocalDate dateFinReservation, double prixTotal, Client client,
			Visiteur visiteur, Repas repas, Hotel hotel) {
		this.dateReservation = dateReservation;
		this.dateFinReservation = dateFinReservation;
		this.prixTotal = prixTotal;
		this.client = client;
		this.visiteur = visiteur;
		this.repas = repas;
		this.hotel = hotel;
	}

	public Reservation(Integer id, LocalDate dateReservation, LocalDate dateFinReservation, double prixTotal,
			Client client, Visiteur visiteur, Repas repas, Hotel hotel) {
		this.id = id;
		this.dateReservation = dateReservation;
		this.dateFinReservation = dateFinReservation;
		this.prixTotal = prixTotal;
		this.client = client;
		this.visiteur = visiteur;
		this.repas = repas;
		this.hotel = hotel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(LocalDate dateReservation) {
		this.dateReservation = dateReservation;
	}

	public LocalDate getDateFinReservation() {
		return dateFinReservation;
	}

	public void setDateFinReservation(LocalDate dateFinReservation) {
		this.dateFinReservation = dateFinReservation;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Visiteur getVisiteur() {
		return visiteur;
	}

	public void setVisiteur(Visiteur visiteur) {
		this.visiteur = visiteur;
	}

	public Repas getRepas() {
		return repas;
	}

	public void setRepas(Repas repas) {
		this.repas = repas;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", dateReservation=" + dateReservation + ", dateFinReservation="
				+ dateFinReservation + ", prixTotal=" + prixTotal + ", client=" + client + ", visiteur=" + visiteur
				+ ", repas=" + repas + ", hotel=" + hotel + "]";
	}

	

}
