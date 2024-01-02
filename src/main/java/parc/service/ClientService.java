package parc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parc.dao.IDAOClient;
import parc.model.Client;

@Service
public class ClientService {

    private final IDAOClient clientRepository;

    @Autowired
    public ClientService(IDAOClient clientRepository) {
        this.clientRepository = clientRepository;
    }

    public String getClientLogin(Integer id) {
        Client client = clientRepository.findById(id).orElse(null);

        if (client != null && client.getCompte() != null) {
            return client.getCompte().getLogin();
        } else {
            return null;
        }
    }

    public int countClients() {
        return (int) clientRepository.count();
    }

    public int findMaxClientId() {
        Integer maxId = clientRepository.findMaxId();
        return maxId != null ? maxId : 0;
    }

    public Client saveClient(Client client) {
        // Initialiser le premier ID à 1 si la table est vide
        if (countClients() == 0) {
            client.setId(1);
        } else {
            // Attribuer automatiquement l'ID suivant
            client.setId(findMaxClientId() + 1);
        }

        return clientRepository.save(client);
    }
}
