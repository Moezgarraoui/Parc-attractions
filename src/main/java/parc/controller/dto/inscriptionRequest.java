package parc.controller.dto;

public class inscriptionRequest {
private String nom,prenom,numero,voie,ville,cp;
private String login,password;
public inscriptionRequest() {
super();
}
public inscriptionRequest(String nom, String prenom, String numero, String voie, String ville, String cp,
String login, String password) {
super();
this.nom = nom;
this.prenom = prenom;
this.numero = numero;
this.voie = voie;
this.ville = ville;
this.cp = cp;
this.login = login;
this.password = password;
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
public String getLogin() {
return login;
}
public void setLogin(String login) {
this.login = login;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}

}