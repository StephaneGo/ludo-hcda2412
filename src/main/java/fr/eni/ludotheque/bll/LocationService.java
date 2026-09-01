package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.dto.LocationRequestDto;
import fr.eni.ludotheque.dto.LocationResponseDto;

public interface LocationService {

    LocationResponseDto louerUnExemplaire(LocationRequestDto locationRequestDto);

}
