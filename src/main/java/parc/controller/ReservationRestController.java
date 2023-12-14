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

import parc.model.Hotel;
import parc.model.Reservation;

@RestController
@RequestMapping("/api/reservation")
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
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
       
        return daoReservation.save(reservation);
    }

    @PutMapping("/{id}")
    public Reservation modifierReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
    	return daoReservation.save(reservation);
    }

    @DeleteMapping("/{id}")
    public Reservation deleteById(@PathVariable Integer id) {
    	return daoReservation.deleteById(id);
    }
	
	
}
