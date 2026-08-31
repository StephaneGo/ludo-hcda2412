package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Genre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    @DisplayName("test d'insertion d'un genre cas ok")
    void testInsertionGenreCasDroit(){
        //Arrange : préparation du test
        genreRepository.deleteAll();
        Genre comedie = Genre.builder()
                .noGenre(1L)
                .libelle("Comédie")
                .build();

        //Act : appel de la méthode à tester
        genreRepository.save(comedie);

        //Assert: Vérifier que le résultat donné par la méthode est le bon
        Optional<Genre> genreOpt = genreRepository.findById(1L);
        assertThat(genreOpt.isPresent()).isTrue();
        assertThat(genreOpt.get().getNoGenre()).isEqualTo(1L);
        assertThat(genreOpt.get().getLibelle()).isEqualTo("Comédie");

    }


}
