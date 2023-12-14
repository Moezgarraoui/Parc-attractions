package parc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import parc.model.Client;

public interface IDAOClient extends JpaRepository<Client,Integer> {

}
