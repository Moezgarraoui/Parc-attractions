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

import parc.dao.IDAOCompte;
import parc.model.Compte;
import parc.model.Compte;



@RestController
@RequestMapping("/api/compte")
@CrossOrigin("*")
public class CompteRestController {

	@Autowired
	private IDAOCompte daoCompte;
	

	
	
	@GetMapping("/{id}")

	public Compte findById(@PathVariable Integer id) 
	{
		Optional<Compte> opt = daoCompte.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		
		return opt.get();
	}
	

	@GetMapping

	public List<Compte> findAll() 
	{
		return daoCompte.findAll();
	}
	
	
	@PostMapping
	
	public Compte insert(@RequestBody Compte compte) 
	{
		return daoCompte.save(compte);
	}
	
	@PutMapping("/{id}")

	public Compte update(@RequestBody Compte compte) 
	{
	
		return daoCompte.save(compte);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoCompte.deleteById(id);
	}
	
}
