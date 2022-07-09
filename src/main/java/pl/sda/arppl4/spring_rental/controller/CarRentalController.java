package pl.sda.arppl4.spring_rental.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.sda.arppl4.spring_rental.model.Car;
import pl.sda.arppl4.spring_rental.model.CarRental;
import pl.sda.arppl4.spring_rental.model.dto.CarDTO;
import pl.sda.arppl4.spring_rental.model.dto.RentCarRequest;
import pl.sda.arppl4.spring_rental.service.CarRentalService;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/rental")
@RequiredArgsConstructor
public class CarRentalController {
    private final CarRentalService carRentalService;

    @GetMapping("/available")
    public List<CarDTO> getAvailableCars() {
        log.info("Wywołano listę samochodow.");
        return carRentalService.getAvailableCars();
        }
    @PostMapping("/rent")
    public void rentCar(@RequestParam Long carId, @RequestBody RentCarRequest request) {
        log.info("Podaj id do wynajecia: " + carId);
        carRentalService.rentCar(carId, request);

    }

}
