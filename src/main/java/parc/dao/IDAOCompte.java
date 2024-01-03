package parc.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import parc.model.Compte;

public interface IDAOCompte extends JpaRepository<Compte, Integer> {

    //Optional<Compte> findByLogin(String login);

    //@Query("select c from Compte c where c.login = ?1 and c.password = ?2 ")
    //Optional<Compte> findByUsernameAndPassword(String login, String password);

public Compte findByLoginAndPassword(String login, String password);
public Compte findByLogin(String login);//registration

}
