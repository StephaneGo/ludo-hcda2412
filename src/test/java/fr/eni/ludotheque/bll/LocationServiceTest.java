package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.dal.ClientRepository;
import fr.eni.ludotheque.dal.ExemplaireRepository;
import fr.eni.ludotheque.dal.LocationRepository;
import fr.eni.ludotheque.dto.LocationRequestDto;
import fr.eni.ludotheque.dto.LocationResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LocationServiceTest {

    @Autowired
    private LocationService locationService;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @Autowired
    private LocationRepository locationRepository;

    @BeforeEach
    public void reinitIndexes()
    {
       //locationRepository.deleteAll();
    }

    @Test
    @DisplayName("test de création d'une location cas ok")
    public void testCreerLocationCasDroit(){

        Client client = clientRepository.findByEmail("bob@eni.fr").orElseThrow(()->new RuntimeException("Client non trouvé"));

        Exemplaire exemplaire = exemplaireRepository.findByCodebarre("101").orElseThrow(()->new RuntimeException("Exemplaire non trouvé"));

        LocationRequestDto locationRequestDto = LocationRequestDto.builder()
                        .codebarre(exemplaire.getCodebarre())
                        .email(client.getEmail())
                                .build();
        //Act
        LocationResponseDto response = locationService.louerUnExemplaire(locationRequestDto);

        //Assert
        assertThat(response.getEmail()).isEqualTo(client.getEmail());
        assertThat(response.getCodebarre()).isEqualTo(exemplaire.getCodebarre());


    }

}
