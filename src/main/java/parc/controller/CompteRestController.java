package parc.controller;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import parc.model.Compte;
import parc.service.compteservice;
@RestController
@CrossOrigin("*")
public class CompteRestController {

    @Autowired
    private compteservice service;

    @PostMapping("/registration")
    @CrossOrigin(origins = "http://localhost:4200")
    public Compte registrationCompte(@RequestBody Compte compte) throws Exception {
        String tempLogin = compte.getLogin();
        if (tempLogin != null && !"".equals(tempLogin)) {
            Compte compteobj = service.fetchUserByLogin(tempLogin);
            if (compteobj != null) {
                throw new Exception("l'utilisateur existe déjà");
            }
        }

        Compte compteobj = service.saveUser(compte);

        return compteobj;
    }

    @PostMapping("/connexion")
    @CrossOrigin(origins = "http://localhost:4200")
    public Compte loginUser(@RequestBody Compte compte) throws Exception {
        String tempLogin = compte.getLogin();
        String tempPass = compte.getPassword();
        Compte compteObj = null;
        if (tempLogin != null && tempPass != null) {
            compteObj = service.fetchUserByLoginAndPassword(tempLogin, tempPass);
        }
        if (compteObj == null) {
            throw new Exception("Problème de connexion");
        }
        return compteObj;
    }
}
