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

import parc.model.Attraction;
import parc.model.MAdulte;



@RestController
@RequestMapping("/api/attraction_adulte")
public class AttractionAdulteRestController {

	@Autowired
	private IDAOAttraction daoAttraction;
	

	
	
	@GetMapping("/{id}")

	public MAdulte findById(@PathVariable Integer id) 
	{
		Optional<Attraction> opt = daoAttraction.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		
		return (MAdulte) opt.get();
	}
	

	@GetMapping

	public List<MAdulte> findAll() 
	{
		return daoAttraction.findAllMAdulte();
	}
	
	
	@PostMapping
	
	public MAdulte insert(@RequestBody MAdulte madulte) 
	{
		return daoAttraction.save(madulte);
	}
	
	@PutMapping("/{id}")

	public MAdulte update(@RequestBody MAdulte madulte) 
	{
	
		return daoAttraction.save(madulte);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoAttraction.deleteById(id);
	}
	
}
