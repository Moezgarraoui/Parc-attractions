package parc.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;

import parc.dao.IDAOCompte;
import parc.model.Compte;
import parc.service.compteservice;

@RestController

@CrossOrigin("*")
public class CompteRestController {

    @Autowired
    private compteservice service;
    
@PostMapping("/registration") 
@CrossOrigin(origins=" http://localhost:4200")

public Compte registartionCompte (@RequestBody Compte compte) throws Exception {//Registration
String tempLogin=compte.getLogin();
if(tempLogin !=null&&!"".equals(tempLogin)) {
	Compte compteobj=service.fetchUserByLogin(tempLogin);
    if(compteobj!=null) {
    	throw new Exception("l'utilisateur déja excicte");
    }
}

	
	Compte compteobj=null;
compteobj=service.saveUser(compte);

return compteobj;
}
   
    
    @PostMapping("/connexion")
    @CrossOrigin(origins=" http://localhost:4200")
    public Compte loginUser(@RequestBody Compte compte)throws Exception {
    	
    	String tempLogin=compte.getLogin();
    	String tempPass=compte.getPassword();
    	Compte compteObj=null;
    	if (tempLogin!=null && tempPass!=null) {
     		compteObj=service.fetchUserByLoginAndPassword(tempLogin, tempPass);
    	}
    	if(compteObj==null) {
    		
    		throw new Exception("probleme de connection");
    	}
    	return compteObj;
    }
    
    
    /*@GetMapping("/{id}")
    public Compte findById(@PathVariable Integer id) {
        Optional<Compte> opt = daoCompte.findById(id);
        if (opt.isEmpty()) {
            return null;
        }

        return opt.get();
    }*/
     
    /*@PostMapping("/connexion")
    public Compte connexion(@RequestBody ConnexionRequest connexionRequest) {
        Optional<Compte> opt = daoCompte.findByUsernameAndPassword(connexionRequest.getLogin(),
                connexionRequest.getPassword());

        if (opt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return opt.get();
    }

    @GetMapping
    public List<Compte> findAll() {
        return daoCompte.findAll();
    }

    @PostMapping
    public Compte insert(@RequestBody Compte compte) {
        return daoCompte.save(compte);
    }

    @PutMapping("/{id}")
    public Compte update(@PathVariable Integer id, @RequestBody Compte compte) {
        if (!daoCompte.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        compte.setId(id); 
        return daoCompte.save(compte);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        daoCompte.deleteById(id);
    }*/
}
