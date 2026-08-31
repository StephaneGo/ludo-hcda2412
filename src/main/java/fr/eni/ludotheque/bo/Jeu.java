package fr.eni.ludotheque.bo;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Jeu {
    @NonNull
    private Long noJeu;
    @NonNull
    private String titre;
    @NonNull
    private String reference;
    private int ageMin;
    private String description;
    private int duree;
    @NonNull
    private Float tarifJour;

    private List<Genre> genres;

}
