package pl.sda.arppl4.spring_rental.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.spring_rental.model.Car;
import pl.sda.arppl4.spring_rental.repository.CarRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


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

    public void deleteById(Long identyfikator) {
        carRepository.deleteById(identyfikator);
    }

    public void updateCar(Car daneAktualizujące) {
        Long identifier = daneAktualizujące.getId();

        Optional<Car> carOptional = carRepository.findById(identifier);
        if (carOptional.isPresent()) {
            Car editedCar = carOptional.get();

            if (daneAktualizujące.getNazwa() != null) {
                editedCar.setNazwa(daneAktualizujące.getNazwa());
            }
            if (daneAktualizujące.getMarka() != null) {
                editedCar.setMarka(daneAktualizujące.getMarka());
            }
            if (daneAktualizujące.getDataProdukcji() != null) {
                editedCar.setDataProdukcji(daneAktualizujące.getDataProdukcji());
            }
            if (daneAktualizujące.getNadwozie() != null) {
                editedCar.setNadwozie(daneAktualizujące.getNadwozie());
            }
            if (daneAktualizujące.getPojemnoscSilnika() != null) {
                editedCar.setPojemnoscSilnika(daneAktualizujące.getPojemnoscSilnika());
            }
            if (daneAktualizujące.getIloscPasazerow() != 0) {
                editedCar.setIloscPasazerow(daneAktualizujące.getIloscPasazerow());
            }

            carRepository.save(editedCar);
            log.info("Samochod został zapisany.");
            return;
        }
        throw new EntityNotFoundException("Nie znaleziono samochodu o id: " + daneAktualizujące.getId());
    }

    public Car findById(Long carId) {
        Optional<Car> carOptional = carRepository.findById(carId);
        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            return car;

        }
        throw new EntityNotFoundException("Nie znaleziono samochodu o id: " + carId);
    }
}

