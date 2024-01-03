package parc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String nom;
	@Enumerated(EnumType.STRING)
	private Specialite specialite;
	
	
	
	public Restaurant() {
	}
	
	public Restaurant(Integer id, String nom, Specialite specialite) {
		this.id = id;
		this.nom = nom;
		this.specialite = specialite;
	}

	public Restaurant(String nom, Specialite specialite) {
		this.nom = nom;
		this.specialite = specialite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	
	
}
