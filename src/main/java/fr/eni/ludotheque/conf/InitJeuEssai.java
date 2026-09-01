package fr.eni.ludotheque.conf;


import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.dal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitJeuEssai {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private JeuRepository jeuRepository;

    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Bean
    public CommandLineRunner jeuEssai(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                //Jeu essai
                //Création des genres
                Genre cartes = Genre.builder()
                        .noGenre(1L)
                        .libelle("cartes")
                        .build();

                Genre strategie = Genre.builder()
                        .noGenre(2L)
                        .libelle("strategie")
                        .build();

                genreRepository.deleteAll();
                Genre cartesSaved = genreRepository.save(cartes);
                Genre strategieSaved = genreRepository.save(strategie);

                //Création des jeux
                jeuRepository.deleteAll();

                Jeu foretMixte = Jeu.builder()
                        .titre("Foret mixte")
                        .description("description du jeu foret mixte")
                        .duree(30)
                        .ageMin(12)
                        .tarifJour(4.5f)
                        .reference("ref-foret-mixte")
                        .build();
                foretMixte.addGenre(cartesSaved);
                foretMixte.addGenre(strategieSaved);
                Jeu foretMixteSaved = jeuRepository.save(foretMixte);

                Jeu skyjo = Jeu.builder()
                        .titre("Skyjo")
                        .description("description du jeu skyjo")
                        .duree(20)
                        .ageMin(7)
                        .tarifJour(4f)
                        .reference("ref-skyjo")
                        .build();
                skyjo.addGenre(cartesSaved);
                Jeu skyJoSaved = jeuRepository.save(skyjo);

                //Création des exemplaires
                exemplaireRepository.deleteAll();

                Exemplaire exemplaireFM = Exemplaire.builder()
                        .codebarre("101")
                        .louable(true)
                        .jeu(foretMixteSaved)
                        .build();

                //Act : appel de la méthode à tester
                Exemplaire savedFM = exemplaireRepository.save(exemplaireFM);


                //Création d'un client
                clientRepository.deleteAll();
                Client bob = Client.builder()
                        .email("bob@eni.fr")
                        .nom("Dupont")
                        .prenom("Bob")
                        .telephone("0625349220")
                        .build();
                clientRepository.save(bob);

                //RAZ locations
                locationRepository.deleteAll();
            }
        };
    }
}
