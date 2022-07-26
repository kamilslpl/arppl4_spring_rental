package pl.sda.arppl4.spring_rental.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.spring_rental.model.Car;
import pl.sda.arppl4.spring_rental.model.dto.CarDTO;
import pl.sda.arppl4.spring_rental.repository.CarRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<CarDTO> findAll() {
        List<Car> carList = carRepository.findAll();

        List<CarDTO> cars = new ArrayList<>();
        for (Car car : carList) {
            cars.add(car.mapToCarDTO());
        }

        return cars;
    }

    public void addCar(Car car) {
        carRepository.save(car);
    }

    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }

    public void update(Long carId, Car editCarInformation) {
        Optional<Car> carOptional = carRepository.findById(carId);
        if (carOptional.isPresent()) {
            Car car = carOptional.get();

            if(editCarInformation.getName()!=null){
                car.setName(editCarInformation.getName());
            }
            if(editCarInformation.getCarGearBox()!=null){
                car.setCarGearBox(editCarInformation.getCarGearBox());
            }
            if(editCarInformation.getProductionDate()!=null){
                car.setProductionDate(editCarInformation.getProductionDate());
            }
            if(editCarInformation.getSeats()!=null){
                car.setSeats(editCarInformation.getSeats());
            }
            if(editCarInformation.getEngineCapacity()!=null){
                car.setEngineCapacity(editCarInformation.getEngineCapacity());
            }
            if(editCarInformation.getBodyType()!=null){
                car.setBodyType(editCarInformation.getBodyType());
            }

            carRepository.save(car);
            return;
        }
        throw new EntityNotFoundException("Unable to find car with id: " + carId);
    }
}