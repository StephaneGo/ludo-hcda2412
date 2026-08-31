package fr.eni.ludotheque.bo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Exemplaire {
    @NonNull
    private Long noExemplaire;
    @NonNull
    private String codebarre;
    @NonNull
    private Boolean louable;

    @NonNull
    private Jeu jeu;

}
