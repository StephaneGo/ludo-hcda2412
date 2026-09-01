package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Exemplaire;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ExemplaireRepository extends MongoRepository<Exemplaire, String> {
    Optional<Exemplaire> findByCodebarre(String codebarre);

}
