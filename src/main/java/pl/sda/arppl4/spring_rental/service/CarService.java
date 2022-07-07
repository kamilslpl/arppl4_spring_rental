package pl.sda.arppl4.spring_rental.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.sda.arppl4.spring_rental.model.Car;
import pl.sda.arppl4.spring_rental.repository.CarRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {
    private final CarService carService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCar(@RequestBody Car car) {
        log.info("Wywołano dodanie samochodu: " + car);
        carService.addCar(car);
    }
}
