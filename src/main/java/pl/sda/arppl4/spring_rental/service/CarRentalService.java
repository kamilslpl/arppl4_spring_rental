package pl.sda.arppl4.spring_rental.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.arppl4.spring_rental.model.Car;
import pl.sda.arppl4.spring_rental.model.CarRental;
import pl.sda.arppl4.spring_rental.repository.CarRentalRepository;
import pl.sda.arppl4.spring_rental.repository.CarRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarRentalService {
        private final CarRentalRepository carRentalRepository;
        private final CarRepository carRepository;

    public List<Car> getAvailableCars() {
        List<Car> carList = carRepository.findAll();

        List<Car> cars = new ArrayList<>();
        for (Car car : carList) {
            if(!isRented(car)){
                cars.add(car);
            }
        }
        return cars;
    }

    private boolean isRented(Car car){
        for (CarRental carRental : car.getCarRentals()) {
            if (carRental.getCzasZwrotu() == null) {
                return true;
            }
        }
        return false;
    }

    public void rentCar(Long carId, CarRental parametry){
        Optional<CarRental> optionalCarRental = carRentalRepository.findById(carId);
        if(optionalCarRental.isPresent()){
            CarRental rentedCar = optionalCarRental.get();
            if (rentedCar.getCzasWynajmu() == null){
                rentedCar.setCzasWynajmu(LocalDateTime.now());
            }
        }
    }


}

