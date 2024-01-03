package parc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parc.dao.IDAOCompte;
import parc.model.Compte;

@Service
public class compteservice {

    @Autowired
    public IDAOCompte repo;

    public Compte fetchUserByLoginAndPassword(String login, String password) {
        return repo.findByLoginAndPassword(login, password);
    }

    public Compte saveUser(Compte compte) { // registration
        // Ajout de la logique pour définir les rôles en fonction du login et du mot de passe
        if ("canard".equals(compte.getLogin()) && "canard".equals(compte.getPassword())) {
            compte.setAdmin(true); // Définir l'utilisateur comme administrateur si le login et le mot de passe sont "canard"
        } else {
            compte.setAdmin(false); // Sinon, définir l'utilisateur comme non-administrateur
        }

        return repo.save(compte);
    }

    public Compte fetchUserByLogin(String login) {
        return repo.findByLogin(login);
    }
}
