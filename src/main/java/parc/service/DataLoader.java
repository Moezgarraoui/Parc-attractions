package parc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import parc.dao.IDAOCompte;
import parc.model.Compte;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private IDAOCompte daoCompte;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Vérifiez si l'utilisateur existe déjà
        if (daoCompte.findByLogin("canard") == null) {
            // Créez un nouvel utilisateur administrateur
            Compte adminUser = new Compte();
            adminUser.setLogin("canard");
            // Encodez le mot de passe (assurez-vous d'avoir le bean PasswordEncoder configuré)
            adminUser.setPassword(passwordEncoder.encode("canard"));
            adminUser.setAdmin(true);

            // Enregistrez l'utilisateur dans la base de données
            daoCompte.save(adminUser);
        }
    }
}
