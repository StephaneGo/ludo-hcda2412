package fr.eni.ludotheque.bo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("clients")
public class Client {
    @Id
    private String noClient;
    @NonNull
    private String nom;
    @NonNull
    private String prenom;
    @NonNull
    @Indexed(unique = true)
    private String email;

    private String telephone;
}
