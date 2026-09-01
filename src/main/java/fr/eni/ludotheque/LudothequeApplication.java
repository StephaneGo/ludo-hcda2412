package fr.eni.ludotheque;

import fr.eni.ludotheque.conf.InitJeuEssai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LudothequeApplication  implements CommandLineRunner {

    @Autowired
    private InitJeuEssai initJeuEssai;

    public static void main(String[] args) {
        SpringApplication.run(LudothequeApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        initJeuEssai.initialiserJeuEssai();
    }
}
