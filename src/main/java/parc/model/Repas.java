package parc.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Repas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private LocalTime heureRepas;
    @Column
    private LocalDate dateRepas;
   
	
    @ManyToOne
	@JoinColumn(name = "restaurant")
	private Restaurant restaurant;
 
    @ManyToOne
	@JoinColumn(name="reservation")
	private Reservation reservation;
    
    public Repas() {
	
	}

	public Repas(LocalTime heureRepas, LocalDate dateRepas, Restaurant restaurant, Reservation reservation) {
		this.heureRepas = heureRepas;
		this.dateRepas = dateRepas;
		this.restaurant = restaurant;
		this.reservation = reservation;
	}

	public Repas(Integer id, LocalTime heureRepas, LocalDate dateRepas, Restaurant restaurant,
			Reservation reservation) {
		this.id = id;
		this.heureRepas = heureRepas;
		this.dateRepas = dateRepas;
		this.restaurant = restaurant;
		this.reservation = reservation;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalTime getHeureRepas() {
		return heureRepas;
	}
	public void setHeureRepas(LocalTime heureRepas) {
		this.heureRepas = heureRepas;
	}
	public LocalDate getDateRepas() {
		return dateRepas;
	}
	public void setDateRepas(LocalDate dateRepas) {
		this.dateRepas = dateRepas;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		return "Repas [id=" + id + ", heureRepas=" + heureRepas + ", dateRepas=" + dateRepas + ", restaurant="
				+ restaurant + ", reservation=" + reservation + "]";
	}
	
	

}