package pl.sda.arppl4.spring_rental.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.spring_rental.exception.CarNotAvailableException;
import pl.sda.arppl4.spring_rental.model.Car;
import pl.sda.arppl4.spring_rental.model.CarRental;
import pl.sda.arppl4.spring_rental.model.dto.CarDTO;
import pl.sda.arppl4.spring_rental.model.dto.RentCarRequest;
import pl.sda.arppl4.spring_rental.repository.CarRentalRepository;
import pl.sda.arppl4.spring_rental.repository.CarRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarRentalService {
        private final CarRentalRepository carRentalRepository;
        private final CarRepository carRepository;

    public List<CarDTO> getAvailableCars() {
        List<Car> carList = carRepository.findAll();

        List<CarDTO> cars = new ArrayList<>();
        for (Car car : carList) {
            if(!isRented(car)){
                cars.add(car.mapToCarDTO());
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
// do innego sprawdzenia
/*
    public void rentACar(Long carId, CarRental parametry){
        Optional<CarRental> optionalCarRental = carRentalRepository.findById(carId);
        if(optionalCarRental.isPresent()){
            CarRental rentedCar = optionalCarRental.get();
            if (rentedCar.getCzasWynajmu() == null){
                rentedCar.setCzasWynajmu(LocalDateTime.now());
            }
        }
    }
*/

    public void rentCar(Long carId, RentCarRequest request) {
        Optional<Car> optionalCar = carRepository.findById(carId);
        if(optionalCar.isPresent()){
            Car car = optionalCar.get();
            if(!isRented(car)){
                CarRental carRental = mapRentCarRequestToCarRental(request);
                carRental.setCar(car);
                carRentalRepository.save(carRental);
                return;
            }
            throw new CarNotAvailableException("Car not available, id: "+ carId);
        }
        throw new EntityNotFoundException("Unable to find car with id: "+ carId);
    }

    private CarRental mapRentCarRequestToCarRental(RentCarRequest request){
        return new CarRental(
                request.getNameOfTheClient(),
                request.getSurnameOfTheClient(),
                request.getHourlyPrice());

    }

}

