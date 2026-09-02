package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Utilisateur;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UtilisateurRepository extends MongoRepository<Utilisateur, String> {
    Optional<Utilisateur> findByLogin(String login);

}
