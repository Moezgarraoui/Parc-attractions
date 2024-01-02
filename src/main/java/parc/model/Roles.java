package parc.model;

public enum Roles {
	GUEST, USER, ADMIN;
	
	public String authority() {
		return "ROLE_" + name();
	}
}
