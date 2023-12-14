package parc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomHotel;
    private int capaciteHotel;
    private double prixHotel;

    

    @OneToOne(mappedBy = "hotel")
    private Reservation reservation;



	public Hotel() {
		
	}



	public Hotel(Integer id, String nomHotel, int capaciteHotel, double prixHotel, Reservation reservation) {
		
		this.id = id;
		this.nomHotel = nomHotel;
		this.capaciteHotel = capaciteHotel;
		this.prixHotel = prixHotel;
		this.reservation = reservation;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNomHotel() {
		return nomHotel;
	}



	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}



	public int getCapaciteHotel() {
		return capaciteHotel;
	}



	public void setCapaciteHotel(int capaciteHotel) {
		this.capaciteHotel = capaciteHotel;
	}



	public double getPrixHotel() {
		return prixHotel;
	}



	public void setPrixHotel(double prixHotel) {
		this.prixHotel = prixHotel;
	}



	public Reservation getReservation() {
		return reservation;
	}



	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}



	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nomHotel=" + nomHotel + ", capaciteHotel=" + capaciteHotel + ", prixHotel="
				+ prixHotel + ", reservation=" + reservation + "]";
	}
    
    
}