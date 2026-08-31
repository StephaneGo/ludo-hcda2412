package fr.eni.ludotheque.bo;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    private Long noLocation;

    @NonNull
    private LocalDateTime dateDebut;

    private LocalDateTime dateRetour;

    private float tarifJour;

    @NonNull
    private Client client;

    @NonNull
    private Exemplaire exemplaire;

}
