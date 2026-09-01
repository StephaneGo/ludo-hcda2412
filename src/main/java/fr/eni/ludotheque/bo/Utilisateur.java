package fr.eni.ludotheque.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("utilisateurs")
public class Utilisateur {
    @Id
    private String noUtilisateur;
    @Indexed(unique = true)
    private String login;
    private String motDePasse;
}
