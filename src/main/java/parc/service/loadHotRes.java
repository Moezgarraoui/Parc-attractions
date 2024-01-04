package parc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import parc.dao.IDAOHotel;
import parc.dao.IDAORestaurant;
import parc.model.Hotel;
import parc.model.Restaurant;
import parc.model.Specialite;

@SpringBootApplication
public class loadHotRes implements CommandLineRunner{
	@Autowired
	IDAOHotel daoHotel;
	@Autowired
	IDAORestaurant daoRestaurant;
	
	@Override
	public void run(String... args) throws Exception {
		daoHotel.save(new Hotel("Harmonie Piano Suites",200,100.0));
		daoHotel.save(new Hotel("Rock Haven Lodge",150,150.0));
		daoRestaurant.save(new Restaurant("Ciné-gastronomie",Specialite.Monde));
		daoRestaurant.save(new Restaurant("Symphonie gourmande",Specialite.Française));
		daoRestaurant.save(new Restaurant("Hard Rock hideaway",Specialite.Américaine));
	}
}
