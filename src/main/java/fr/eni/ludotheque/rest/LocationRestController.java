package fr.eni.ludotheque.rest;

import fr.eni.ludotheque.bll.LocationService;
import fr.eni.ludotheque.dto.LocationRequestDto;
import fr.eni.ludotheque.dto.LocationResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LocationRestController {

    private LocationService locationService;

    @PostMapping("/api/locations")
    public ResponseEntity<ApiResponse<LocationResponseDto>> creerLocation(@RequestBody LocationRequestDto locationRequest){
        LocationResponseDto locationResponseDto =null;
        try {
            locationResponseDto = locationService.louerUnExemplaire(locationRequest);
        }catch (RuntimeException re){
            return ResponseEntity.badRequest().body(new ApiResponse<>(null, "Echec de la creation de la location", false));
        }

        return  ResponseEntity.ok().body(new ApiResponse<>(locationResponseDto, "location créée avec succès", true));
    }

}
