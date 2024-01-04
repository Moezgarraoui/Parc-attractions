package parc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import parc.dao.IDAOCompte;
import parc.model.Compte;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private IDAOCompte daoCompte;

    @Override
    public void run(String... args) throws Exception {
        // Vérifiez si l'utilisateur existe déjà
        if (daoCompte.findByLogin("canard") == null) {
            // Créez un nouvel utilisateur administrateur
            Compte compte = new Compte();
            compte.setLogin("canard");
            // Stockez le mot de passe en texte brut (NON recommandé)
            compte.setPassword("canard");
            compte.setAdmin(true);

            // Enregistrez l'utilisateur dans la base de données
            daoCompte.save(compte);
        }
    }
}
