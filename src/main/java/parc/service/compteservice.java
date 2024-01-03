package parc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parc.dao.IDAOCompte;
import parc.model.Compte;

@Service
public class compteservice {

	@Autowired
	public IDAOCompte repo;
	public Compte fetchUserByLoginAndPassword (String login,String password) {
 return repo.findByLoginAndPassword(login, password);
	}
	public Compte saveUser(Compte compte) { //registration
		return repo.save(compte);
		
	}
	public Compte fetchUserByLogin(String login) {
		return repo.findByLogin(login);
	}
}
