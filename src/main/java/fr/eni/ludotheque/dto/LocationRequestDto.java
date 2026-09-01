package fr.eni.ludotheque.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LocationRequestDto {
    //Email du client
    private String email;

    //codebarre de l'exemplaire
    private String codebarre;
}
