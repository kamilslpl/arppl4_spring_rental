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

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;


    public List<Car> getAllCars() {
        return carRepository.findAll();
    }


    public void addProduct(Car car) {
        carRepository.save(car);


    }
}

