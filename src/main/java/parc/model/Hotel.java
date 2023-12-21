package parc.model;

import jakarta.persistence.Column;
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
    @Column
    private String nomHotel;
    @Column
    private int capaciteHotel;
    @Column
    private double prixHotel;


	public Hotel() {
		
	}
public Hotel( String nomHotel, int capaciteHotel, double prixHotel, Reservation reservation) {
		
		
		this.nomHotel = nomHotel;
		this.capaciteHotel = capaciteHotel;
		this.prixHotel = prixHotel;

	}

	public Hotel(Integer id, String nomHotel, int capaciteHotel, double prixHotel, Reservation reservation) {
		
		this.id = id;
		this.nomHotel = nomHotel;
		this.capaciteHotel = capaciteHotel;
		this.prixHotel = prixHotel;

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



	



	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nomHotel=" + nomHotel + ", capaciteHotel=" + capaciteHotel + ", prixHotel="
				+ prixHotel + ", reservation=" + "]";
	}
    
    
}