package fr.eni.ludotheque.conf;


import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.dal.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitJeuEssai {

    @Autowired
    private GenreRepository genreRepository;

    @Bean
    public CommandLineRunner jeuEssai(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                //Jeu essai
                Genre cartes = Genre.builder()
                        .noGenre(1L)
                        .libelle("cartes")
                        .build();

                Genre strategie = Genre.builder()
                        .noGenre(2L)
                        .libelle("strategie")
                        .build();

                genreRepository.deleteAll();
                genreRepository.save(cartes);
                genreRepository.save(strategie);

            }
        };
    }
}
