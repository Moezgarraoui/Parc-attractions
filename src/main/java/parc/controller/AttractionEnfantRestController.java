package parc.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
import parc.model.MEnfant;



@RestController
@RequestMapping("/api/attraction_enfant")
public class AttractionEnfantRestController {

	@Autowired
	private IDAOAttraction daoAttraction;
	

	
	
	@GetMapping("/{id}")

	public MEnfant findById(@PathVariable Integer id) 
	{
		Optional<Attraction> opt = daoAttraction.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		
		return (MEnfant) opt.get();
	}
	

	@GetMapping

	public List<MEnfant> findAll() 
	{
		return daoAttraction.findAllMEnfant();
	}
	
	
	@PostMapping
	
	public MEnfant insert(@RequestBody MEnfant menfant) 
	{
		return daoAttraction.save(menfant);
	}
	
	@PutMapping("/{id}")

	public MEnfant update(@RequestBody MEnfant menfant) 
	{
	
		return daoAttraction.save(menfant);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoAttraction.deleteById(id);
	}
	
}
