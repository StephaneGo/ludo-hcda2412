package fr.eni.ludotheque.bo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("exemplaires")
public class Exemplaire {

    @Id
    private String noExemplaire;

    @NonNull
    private String codebarre;
    @NonNull
    private Boolean louable;

    @NonNull
    private Jeu jeu;

}
