package pl.sda.arppl4.spring_rental.controller;


import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.arppl4.spring_rental.model.Car;
import pl.sda.arppl4.spring_rental.model.dto.CarDTO;
import pl.sda.arppl4.spring_rental.service.CarService;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/car")
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
    public List<CarDTO> getAllCarss() {
        log.info("Wywołano listę samochodow.");
        List<CarDTO> list = carService.findAll();
        return list;
    }

/*    @GetMapping("/list")
    public List<Car> getAllCarss() {
        log.info("Wywołano listę samochodow.");
        List<Car> list = carService.getAllCars();
        return list;
    }
    */

    @DeleteMapping("/delete/{identifier}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable(name = "identifier") Long identyfikator) {
        log.info("Wywołano usunięcie samochodu: " + identyfikator);
        carService.deleteById(identyfikator);
    }

    @PatchMapping("/update")
    public void updateCar(@RequestBody Car car) {
        log.info("Wywołano aktualizację samochodu: " + car);
        carService.updateCar(car);
    }

    @ApiOperation(value = "znajdzStudenta", notes = "Ten endpoint pozwala na znajdowanie studentów po ich identyfikatorach w bazie danych.")
    @GetMapping("/{identifier}")
    public Car findCar( Long carId) {
        log.info("Wywołano metodę findStudent: " + carId);

        return carService.findById(carId);

    }
}

