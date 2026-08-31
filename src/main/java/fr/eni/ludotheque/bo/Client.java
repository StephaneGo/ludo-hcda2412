package fr.eni.ludotheque.bo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
    @NonNull
    private Long noClient;
    @NonNull
    private String nom;
    @NonNull
    private String prenom;
    @NonNull
    private String email;
    private String telephone;
}
