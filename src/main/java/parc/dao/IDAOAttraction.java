package parc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import parc.model.Attraction;
import parc.model.MAdulte;
import parc.model.MEnfant;



public interface IDAOAttraction extends JpaRepository <Attraction,Integer> {
	@Query("from MAdulte")
	public List<MAdulte> findAllMAdulte();
	@Query("from MEnfant")
	public List<MEnfant> findAllMEnfant();
}
