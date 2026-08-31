package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bo.Jeu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class JeuRepositoryTest {

    @Autowired
    private JeuRepository jeuRepository;

    @Test
    @DisplayName("test d'insertion d'un jeu cas ok")
    void testInsertionJeuCasDroit(){
        //Arrange : préparation du test
        jeuRepository.deleteAll();
        Genre cartes = Genre.builder()
                .noGenre(1L)
                .libelle("Cartes")
                .build();

        Jeu jeu = Jeu.builder()
                .titre("Foret mixte")
                .description("description du jeu foret mixte")
                .duree(30)
                .ageMin(12)
                .tarifJour(4.5f)
                .reference("ref-foret-mixte")
                .build();
        jeu.addGenre(cartes);

        //Act : appel de la méthode à tester
        Jeu jeuSaved = jeuRepository.save(jeu);

        //Assert: Vérifier que le résultat donné par la méthode est le bon
        Optional<Jeu> opt = jeuRepository.findById(jeuSaved.getNoJeu());
        assertThat(opt.isPresent()).isTrue();
        assertThat(opt.get().getTitre()).isEqualTo("Foret mixte");

    }


}
