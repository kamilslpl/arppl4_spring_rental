package pl.sda.arppl4.spring_rental.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.arppl4.spring_rental.model.Car;
import pl.sda.arppl4.spring_rental.model.CarRental;
import pl.sda.arppl4.spring_rental.service.CarRentalService;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/rental")
@RequiredArgsConstructor
public class CarRentalController {
    private final CarRentalService carRentalService;

    @GetMapping("/available")
    public List<Car> getAvailableCars() {
        log.info("Wywołano listę samochodow.");
        return carRentalService.getAvailableCars();
        }




}
