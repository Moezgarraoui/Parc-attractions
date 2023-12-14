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

import parc.model.Repas;

@RestController
@RequestMapping("/api/repas")
public class RepasRestController {
	@Autowired
	IDAORepas daoRepas;

	@GetMapping
	public List<Repas> findAll() {

		return daoRepas.findAll();
	}

	@GetMapping("/{id}")
	public Repas findById(@PathVariable Integer id) {
		Optional<Repas> opt = daoRepas.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}

		return opt.get();
	}

	@PostMapping
	public Repas insert(@RequestBody Repas repas) {

		return daoRepas.save(repas);
	}

	@PutMapping("/{id}")
	public Repas update(@PathVariable Integer id, @RequestBody Repas repas) {
		return daoRepas.save(repas);
	}

	@DeleteMapping("/{id}")
	public Repas delete(@PathVariable Integer id) {
		return daoRepas.deleteById(id);
	}
}
