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

import parc.dao.IDAOClient;
import parc.model.Client;
import parc.model.Client;



@RestController
@RequestMapping("/api/client")
public class ClientRestController {

	@Autowired
	private IDAOClient daoClient;
	

	
	
	@GetMapping("/{id}")

	public Client findById(@PathVariable Integer id) 
	{
		Optional<Client> opt = daoClient.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		
		return opt.get();
	}
	

	@GetMapping

	public List<Client> findAll() 
	{
		return daoClient.findAll();
	}
	
	
	@PostMapping
	
	public Client insert(@RequestBody Client client) 
	{
		return daoClient.save(client);
	}
	
	@PutMapping("/{id}")

	public Client update(@RequestBody Client client) 
	{
	
		return daoClient.save(client);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoClient.deleteById(id);
	}
	
}
