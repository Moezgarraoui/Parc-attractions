package parc.controller.dto;

import parc.model.Compte;

public class inscriptionRequest {
private String nom,prenom,numero,voie,ville,cp;
private Compte compte;
public inscriptionRequest() {
super();
}
public inscriptionRequest(String nom, String prenom, String numero, String voie, String ville, String cp,
Compte compte) {
super();
this.nom = nom;
this.prenom = prenom;
this.numero = numero;
this.voie = voie;
this.ville = ville;
this.cp = cp;
this.compte=compte;
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


}