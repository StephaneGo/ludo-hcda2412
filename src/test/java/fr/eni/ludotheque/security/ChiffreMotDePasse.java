package fr.eni.ludotheque.security;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class ChiffreMotDePasse {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("Pas un test !! Sert à chiffrer des mots de passe")
    void chiffreMotDePasse(){
        System.out.println("azerty :");
        System.out.println(passwordEncoder.encode("azerty"));
        System.out.println("Pa$$w0rd :");
        System.out.println(passwordEncoder.encode("Pa$$w0rd"));
    }


}
