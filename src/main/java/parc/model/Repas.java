package parc.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Repas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalTime heureRepas;
    private LocalDate dateRepas;
    @OneToOne(mappedBy = "repas")
    private Reservation reservation;
	
    
    
    
    
    public Repas() {
	
	}
	public Repas(Integer id, LocalTime heureRepas, LocalDate dateRepas, Reservation reservation) {
		
		this.id = id;
		this.heureRepas = heureRepas;
		this.dateRepas = dateRepas;
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
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	@Override
	public String toString() {
		return "Repas [id=" + id + ", heureRepas=" + heureRepas + ", dateRepas=" + dateRepas + ", reservation="
				+ reservation + "]";
	}
    

}