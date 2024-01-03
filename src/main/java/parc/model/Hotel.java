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
    private Integer capaciteHotel;
    @Column
    private Double prixHotel;


	public Hotel() {
		
	}
public Hotel( String nomHotel, Integer capaciteHotel, Double prixHotel, Reservation reservation) {
		
		
		this.nomHotel = nomHotel;
		this.capaciteHotel = capaciteHotel;
		this.prixHotel = prixHotel;

	}

	public Hotel(Integer id, String nomHotel, Integer capaciteHotel, Double prixHotel, Reservation reservation) {
		
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
	public Integer getCapaciteHotel() {
		return capaciteHotel;
	}
	public void setCapaciteHotel(Integer capaciteHotel) {
		this.capaciteHotel = capaciteHotel;
	}
	public Double getPrixHotel() {
		return prixHotel;
	}
	public void setPrixHotel(Double prixHotel) {
		this.prixHotel = prixHotel;
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nomHotel=" + nomHotel + ", capaciteHotel=" + capaciteHotel + ", prixHotel="
				+ prixHotel + ", reservation=" + "]";
	}
    
    
}