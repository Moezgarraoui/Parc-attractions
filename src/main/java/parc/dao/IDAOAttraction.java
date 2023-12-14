package parc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import parc.model.Attraction;



public interface IDAOAttraction extends JpaRepository <Attraction,Integer> {
	
}
