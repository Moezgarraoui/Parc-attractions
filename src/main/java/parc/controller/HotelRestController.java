package parc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import parc.dao.IDAOHotel;
import parc.model.Hotel;
import parc.model.Repas;


	@RestController
	@RequestMapping("/api/hotel")
	
	public class HotelRestController {
		
		@Autowired
		IDAOHotel daoHotel;
		
		@GetMapping
	    public List<Hotel> findAll() {
	        
	        return daoHotel.findAll();
	    }

	    @GetMapping("/{id}")
	    public Hotel findById(@PathVariable Integer id) {
	    	Optional<Hotel> opt = daoHotel.findById(id);
			if(opt.isEmpty()) 
			{
				return null;
			}

			return opt.get();
	        
	    }

	    @PostMapping
	    public Hotel insert(@RequestBody Hotel hotel) {
	       
	        return daoHotel.save(hotel);
	    }

	    @PutMapping("/{id}")
	    public Hotel update(@PathVariable Integer id, @RequestBody Hotel hotel) {
	    	return daoHotel.save(hotel);
	    }

	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable Integer id) {
	    	daoHotel.deleteById(id);
	    }
}
