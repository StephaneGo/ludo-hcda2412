package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.bo.Jeu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ExemplaireRepositoryTest {

    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @Test
    @DisplayName("test d'insertion d'un nouvel exemplaire")
    void testInsertionExemplaireCasDroit(){
        //Arrange : préparation du test
        exemplaireRepository.deleteAll();
        Jeu jeu = Jeu.builder()
                .noJeu(1L)
                .titre("Foret mixte")
                .description("description du jeu foret mixte")
                .duree(30)
                .ageMin(12)
                .tarifJour(4.5f)
                .reference("ref-foret-mixte")
                .build();

        Exemplaire exemplaire = Exemplaire.builder()
                .codebarre("101")
                .louable(true)
                .jeu(jeu)
                .build();

        //Act : appel de la méthode à tester
        Exemplaire saved = exemplaireRepository.save(exemplaire);

        //Assert: Vérifier que le résultat donné par la méthode est le bon
        Optional<Exemplaire> exemplaireOpt = exemplaireRepository.findById(saved.getNoExemplaire());
        assertThat(exemplaireOpt.isPresent()).isTrue();
        assertThat(exemplaireOpt.get().getCodebarre()).isEqualTo("101");
        assertThat(exemplaireOpt.get().getJeu().getTitre()).isEqualTo("Foret mixte");

    }


}
