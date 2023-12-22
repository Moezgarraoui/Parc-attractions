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

import parc.dao.IDAOReservation;
import parc.model.Reservation;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin("*")
public class ReservationRestController {
	@Autowired
	IDAOReservation daoReservation;
	
	
	
	@GetMapping
    public List<Reservation> findAll() {
        
        return daoReservation.findAll();
    }

    @GetMapping("/{id}")
    public Reservation findById(@PathVariable Integer id) {
    	Optional<Reservation> opt = daoReservation.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}

		return opt.get();
        
    }

    @PostMapping
    public Reservation insert(@RequestBody Reservation reservation) {
       
        return daoReservation.save(reservation);
    }

    @PutMapping("/{id}")
    public Reservation update(@PathVariable Integer id, @RequestBody Reservation reservation) {
    	return daoReservation.save(reservation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	 daoReservation.deleteById(id);
    }
	
	
}
