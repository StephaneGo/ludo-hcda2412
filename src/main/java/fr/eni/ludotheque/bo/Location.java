package fr.eni.ludotheque.bo;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    @NonNull
    private Long noLocation;

    @NonNull
    private LocalDateTime dateDebut;

    private LocalDateTime dateRetour;

    private float tarifJour;
}
