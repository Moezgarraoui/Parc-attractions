package parc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import parc.model.Restaurant;



public interface IDAORestaurant extends JpaRepository <Restaurant,Integer>{

}
