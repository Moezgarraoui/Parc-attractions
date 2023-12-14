package parc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import parc.model.Visiteur;



public interface IDAOVisiteur extends JpaRepository <Visiteur,Integer>{

}
