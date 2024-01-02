package parc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import parc.dao.IDAOClient;
import parc.dao.IDAOCompte;
import parc.model.Client;
import parc.model.Compte;

@Service
public class InscriptionService {

    private  IDAOClient daoClient;
    private  IDAOCompte daoCompte;
    //private  ClientService clientService; // Injection de ClientService

    @Autowired
    public InscriptionService(IDAOClient daoClient, IDAOCompte daoCompte, ClientService clientService) {
        this.daoClient = daoClient;
        this.daoCompte = daoCompte;
        //this.clientService = clientService;
    }

    @Transactional
    public Client fetchUserPrenom(String prenom) {
        return daoClient.findByPrenom(prenom);
    }

    @Transactional
    public Client saveUser(Client client) {
        // Vérifiez si le compte du client n'est pas null
        if (client.getCompte() != null) {
            // Continuez avec l'enregistrement de l'utilisateur
            Compte compte = client.getCompte();

            // Enregistrez d'abord le compte s'il n'a pas encore été enregistré
            if (compte.getId() == null) {
                // Assurez-vous que le client n'est pas déjà associé à un compte existant
                if (daoCompte.findByLogin(compte.getLogin()) == null) {
                    compte = daoCompte.save(compte);

                    // Assurez-vous que le client est associé au compte
                    client.setCompte(compte);
                    client = daoClient.save(client);
                } else {
                    // Gérez le cas où le client est déjà associé à un compte (ajoutez le traitement approprié)
                    throw new IllegalArgumentException("Un compte avec ce login existe déjà.");
                }
            } else {
                // Gérez le cas où le compte a déjà un identifiant (ajoutez le traitement approprié)
                throw new IllegalArgumentException("Le compte a déjà un identifiant.");
            }

            // Enregistrez ensuite le client si ce n'est pas déjà fait
            return client;
        } else {
            // Gérez le cas où le compte est null (ajoutez le traitement approprié)
            throw new IllegalArgumentException("Le compte du client ne peut pas être null.");
        }
    }

    

    

    

    

    

    @Transactional
    public Client fetchUserByNom(String nom) {
        return daoClient.findByNom(nom);
    }
}
