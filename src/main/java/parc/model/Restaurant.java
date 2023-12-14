package parc.model;

import jakarta.persistence.Column;

public class Restaurant {
	@Column
	private Integer id;
	@Column
	private Specialite specialite;
}
