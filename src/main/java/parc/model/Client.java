package parc.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom,prenom,numero,voie,ville,cp;
	
	
	@OneToOne
	@JoinColumn(name="compte")
	private Compte compte;

	public Client() {
	}

	public Client(String nom, String prenom, String numero, String voie, String ville, String cp, Compte compte) {
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.cp = cp;
		this.compte = compte;
	}

	public Client(Integer id, String nom, String prenom, String numero, String voie, String ville, String cp,
			Compte compte) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.cp = cp;
		this.compte = compte;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", numero=" + numero + ", voie=" + voie
				+ ", ville=" + ville + ", cp=" + cp + ", compte=" + compte + "]";
	}
	
	
	
}
