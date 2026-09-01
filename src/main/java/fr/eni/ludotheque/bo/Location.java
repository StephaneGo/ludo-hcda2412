package fr.eni.ludotheque.bo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@Document("locations")
public class Location {
    @Id
    private String noLocation;

    @NonNull
    private LocalDateTime dateDebut;

    private LocalDateTime dateRetour;

    private float tarifJour;

    @NonNull
    private Client client;

    @NonNull
    private Exemplaire exemplaire;

}
