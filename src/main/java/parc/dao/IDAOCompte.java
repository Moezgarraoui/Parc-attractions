package parc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import parc.model.Compte;



public interface IDAOCompte extends JpaRepository<Compte,Integer> {

}
