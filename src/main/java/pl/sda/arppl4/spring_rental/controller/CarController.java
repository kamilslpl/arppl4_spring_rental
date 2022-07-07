package pl.sda.arppl4.spring_rental.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.arppl4.spring_rental.model.Car;
import pl.sda.arppl4.spring_rental.service.CarService;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/rents")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCar(@RequestBody Car car) {
        log.info("Wywołano dodanie samochodu: " + car);
        carService.addProduct(car);

    }

    @GetMapping("/list")
    public List<Car> getAllCarss() {
        log.info("Wywołano listę produktów.");
        List<Car> list = carService.getAllCars();
        return list;
    }

}
