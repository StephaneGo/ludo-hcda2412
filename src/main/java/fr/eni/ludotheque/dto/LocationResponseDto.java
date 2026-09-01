package fr.eni.ludotheque.dto;

import fr.eni.ludotheque.bo.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationResponseDto {
    //infos client
    private String noClient;
    private String nom;
    private String prenom;
    private String email;

    //infos exemplaire
    private String noExemplaire;
    private String codebarre;

    //infos jeu
    private String titre;
    private String reference;
    private int ageMin;
    private String description;
    private int duree;
    private Float tarifJour;


    public static LocationResponseDto toDto(Location location){
        return LocationResponseDto.builder()
                .noClient(location.getClient().getNoClient())
                .email(location.getClient().getEmail())
                .noExemplaire(location.getExemplaire().getNoExemplaire())
                .codebarre(location.getExemplaire().getCodebarre())
                .titre(location.getExemplaire().getJeu().getTitre())
                .reference(location.getExemplaire().getJeu().getReference())
                .ageMin(location.getExemplaire().getJeu().getAgeMin())
                .description(location.getExemplaire().getJeu().getDescription())
                .duree(location.getExemplaire().getJeu().getDuree())
                .tarifJour(location.getExemplaire().getJeu().getTarifJour())
                .build();
    }


}
