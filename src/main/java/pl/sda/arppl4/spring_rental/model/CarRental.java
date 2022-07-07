package pl.sda.arppl4.spring_rental.model;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@ApiModel(value = "CarRental", description = "Encja reprezentująca instancjy samochod w bazie danych.")

public class CarRental {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment

    private Long id;

    private String imie;
    private String nazwisko;
    private LocalDateTime czasWynajmu;
    private LocalDateTime czasZwrotu;
    private int cenaNajmu;

    @ManyToOne
    private Car car;

    public CarRental(Long id, String imie, String nazwisko, LocalDateTime czasWynajmu, int cenaNajmu, Car car) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.czasWynajmu = czasWynajmu;
        this.cenaNajmu = cenaNajmu;
        this.car = car;
    }
}
