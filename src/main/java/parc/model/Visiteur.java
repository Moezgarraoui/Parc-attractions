package parc.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Visiteur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private int age;
	@Column
	private double taille;
	@ManyToOne
	@JoinColumn(name="reservation")
	private Reservation reservation;
	public Visiteur() {
	}
	public Visiteur(String nom, String prenom, int age, double taille) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.taille = taille;
	}
	public Visiteur(Integer id, String nom, String prenom, int age, double taille) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.taille = taille;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getTaille() {
		return taille;
	}
	public void setTaille(double taille) {
		this.taille = taille;
	}
	@Override
	public String toString() {
		return "Visiteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", taille=" + taille
				+ "]";
	}
	
	
}
