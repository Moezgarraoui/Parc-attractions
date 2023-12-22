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

import parc.dao.IDAOAttraction;
import parc.model.Attraction;
import parc.model.Attraction;



@RestController
@RequestMapping("/api/attraction")
//http://localhost:8080/api/attraction
@CrossOrigin("*")
public class AttractionRestController {

	@Autowired
	private IDAOAttraction daoAttraction;
	

	
	
	@GetMapping("/{id}")

	public Attraction findById(@PathVariable Integer id) 
	{
		Optional<Attraction> opt = daoAttraction.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		
		return opt.get();
	}
	

	@GetMapping

	public List<Attraction> findAll() 
	{
		return daoAttraction.findAll();
	}
	
	
	@PostMapping
	
	public Attraction insert(@RequestBody Attraction attraction) 
	{
		return daoAttraction.save(attraction);
	}
	
	@PutMapping("/{id}")

	public Attraction update(@RequestBody Attraction attraction) 
	{
	
		return daoAttraction.save(attraction);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoAttraction.deleteById(id);
	}
	
}
