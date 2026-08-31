package fr.eni.ludotheque.bo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Document("jeux")
public class Jeu {

    @Id
    private String noJeu;

    @NonNull
    private String titre;
    @NonNull
    private String reference;
    private int ageMin;
    private String description;
    private int duree;
    @NonNull
    private Float tarifJour;

    private @Builder.Default List<Genre> genres = new ArrayList<>();

    public void addGenre(Genre genre){
        genres.add(              genre        );
    }

}
