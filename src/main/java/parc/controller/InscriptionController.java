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

@PostMapping("/inscription")
public Client inscription(@RequestBody @Valid inscriptionRequest inscriptionRequest, BindingResult result) {
    if (result.hasErrors()) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Validation failed");
    }

    Client client = new Client();
    BeanUtils.copyProperties(inscriptionRequest, client);
    client = daoClient.save(client);

    Compte compte = new Compte();
    BeanUtils.copyProperties(inscriptionRequest, compte);
    compte = daoCompte.save(compte);

    assignRolesBasedOnAdminStatus(compte);
   

    return client;
}
private void assignRolesBasedOnAdminStatus(Compte compte) {
    // Vérifiez si le login est "canard" et le mot de passe est "canard"
	 if ("canard".equals(compte.getLogin()) && "canard".equals(compte.getPassword())) {
	        // Si oui, attribuez le rôle d'administrateur
	        compte.setAdmin(true);
	    } else {
	        compte.setAdmin(false);
	    }

    // Enregistrez les modifications dans la base de données
    daoCompte.save(compte);
}
}