package parc.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import parc.dao.IDAOVisiteur;
import parc.model.Visiteur;



@RestController
@RequestMapping("/api/visiteur")
@CrossOrigin("*")
public class VisiteurRestController {

	@Autowired
	private IDAOVisiteur daoVisiteur;
	

	
	
	@GetMapping("/{id}")

	public Visiteur findById(@PathVariable Integer id) 
	{
		Optional<Visiteur> opt = daoVisiteur.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		
		return opt.get();
	}
	

	@GetMapping

	public List<Visiteur> findAll() 
	{
		return daoVisiteur.findAll();
	}
	
	
	@PostMapping
	
	public Visiteur insert(@RequestBody Visiteur visiteur) 
	{
		return daoVisiteur.save(visiteur);
	}
	
	@PutMapping("/{id}")

	public Visiteur update(@RequestBody Visiteur visiteur) 
	{
	
		return daoVisiteur.save(visiteur);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoVisiteur.deleteById(id);
	}
	
}
