package parc.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;

import parc.dao.IDAOCompte;
import parc.model.Client;
import parc.model.Compte;
import parc.service.InscriptionService;

@RestController

@CrossOrigin("*")
public class InscriptionController {

    @Autowired
    private InscriptionService service;
    
@PostMapping("/inscription") 
@CrossOrigin(origins=" http://localhost:4200")

public Client registartionClient (@RequestBody Client client) throws Exception {//Registration
String tempNom=client.getNom();
if(tempNom !=null&&!"".equals(tempNom)) {
	Client clientobj=service.fetchUserPrenom(tempNom);
    if(clientobj!=null) {
    	throw new Exception("l'utilisateur déja excicte");
    }
}

	
	Client clientobj=null;
	clientobj=service.saveUser(client);

return clientobj;
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
