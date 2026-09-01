package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.bo.Location;
import fr.eni.ludotheque.dal.ClientRepository;
import fr.eni.ludotheque.dal.ExemplaireRepository;
import fr.eni.ludotheque.dal.LocationRepository;
import fr.eni.ludotheque.dto.LocationRequestDto;
import fr.eni.ludotheque.dto.LocationResponseDto;
import fr.eni.ludotheque.exceptions.ClientNotFound;
import fr.eni.ludotheque.exceptions.ExemplaireNotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class LocationServiceImpl implements  LocationService{

    private ExemplaireRepository exemplaireRepository;

    private ClientRepository clientRepository;

    private LocationRepository locationRepository;

    public LocationResponseDto louerUnExemplaire(LocationRequestDto locationRequestDto){

        Client client = clientRepository.findByEmail(locationRequestDto.getEmail()).orElseThrow(ClientNotFound::new);

        Exemplaire exemplaire = exemplaireRepository.findByCodebarre(locationRequestDto.getCodebarre())
                .orElseThrow(ExemplaireNotFound::new);

        Location newLocation = Location.builder()
                .client(client)
                .exemplaire(exemplaire)
                .dateDebut(LocalDateTime.now())
                .build();

        Location savedLocation = locationRepository.save(newLocation);

        return LocationResponseDto.toDto(savedLocation);

    }

}
