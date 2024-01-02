package parc.controller;


import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import parc.controller.dto.inscriptionRequest;
import parc.dao.IDAOClient;
import parc.dao.IDAOCompte;
import parc.model.Client;
import parc.model.Compte;
import parc.model.Roles;
import parc.service.InscriptionService;


@RestController

@CrossOrigin("*")
public class InscriptionController {
@Autowired
IDAOClient daoClient;
@Autowired
IDAOCompte daoCompte;
@Autowired
private InscriptionService service;

/*@PostMapping("/inscription")
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
}*/
@PostMapping("/inscription")
public Client inscription(@RequestBody @Valid inscriptionRequest inscriptionRequest, BindingResult result) {
if(result.hasErrors()) {
throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
}

Client client = new Client();

BeanUtils.copyProperties(inscriptionRequest, client);

/*Client.getRoles().add(Roles.USER);*/

client = daoClient.save(client);

Compte compte = new Compte();

BeanUtils.copyProperties(inscriptionRequest, compte);

compte = daoCompte.save(compte);

return client;
}




}