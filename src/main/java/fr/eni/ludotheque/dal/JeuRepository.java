package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Jeu;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JeuRepository extends MongoRepository<Jeu, String> {


}
