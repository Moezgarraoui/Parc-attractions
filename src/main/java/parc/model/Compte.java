package parc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String login;
	private String password;
	private boolean admin;
	public Compte() {
	}
	public Compte(String login, String password, boolean admin) {
		this.login = login;
		this.password = password;
		this.admin = admin;
	}
	public Compte(Integer id, String login, String password, boolean admin) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.admin = admin;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "Compte [id=" + id + ", login=" + login + ", password=" + password + ", admin=" + admin + "]";
	}
	
	
}
