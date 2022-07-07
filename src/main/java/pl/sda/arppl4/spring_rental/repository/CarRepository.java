package pl.sda.arppl4.spring_rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.arppl4.spring_rental.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
