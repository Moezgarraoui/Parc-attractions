package parc.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import parc.model.Client;
import parc.model.Compte;


public interface IDAOClient extends JpaRepository<Client, Integer> {
	
	public Client findByPrenom(String prenom);//registration
	
	public Client findByNom(String nom);
	 @Query(value = "SELECT MAX(id) FROM Client", nativeQuery = true)
	    Integer findMaxId();
	
	

}
