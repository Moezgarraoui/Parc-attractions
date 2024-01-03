package parc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import parc.dao.IDAORestaurant;
import parc.model.Restaurant;
import parc.model.Repas;


	@RestController
	@RequestMapping("/api/restaurant")
	@CrossOrigin("*")
	public class RestaurantRestController {
		
		@Autowired
		IDAORestaurant daoRestaurant;
		
		@GetMapping
	    public List<Restaurant> findAll() {
	        
	        return daoRestaurant.findAll();
	    }

	    @GetMapping("/{id}")
	    public Restaurant findById(@PathVariable Integer id) {
	    	Optional<Restaurant> opt = daoRestaurant.findById(id);
			if(opt.isEmpty()) 
			{
				return null;
			}

			return opt.get();
	        
	    }

	    @PostMapping
	    public Restaurant insert(@RequestBody Restaurant restaurant) {
	       
	        return daoRestaurant.save(restaurant);
	    }

	    @PutMapping("/{id}")
	    public Restaurant update(@PathVariable Integer id, @RequestBody Restaurant restaurant) {
	    	return daoRestaurant.save(restaurant);
	    }

	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable Integer id) {
	    	daoRestaurant.deleteById(id);
	    }
}
