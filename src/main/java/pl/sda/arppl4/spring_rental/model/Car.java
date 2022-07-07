package pl.sda.arppl4.spring_rental.model;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Car", description = "Encja reprezentująca instancjy samochod w bazie danych.")

public class Car {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment

    private Long id;

    private String nazwa;
    private String marka;
    private LocalDate dataProdukcji;

    @Enumerated(EnumType.STRING)
    private CarNadwozie nadwozie;
    private int iloscPasazerow;
    @Enumerated(EnumType.STRING)
    private CarSkrzynia skrzynia;
    private Double pojemnoscSilnika;

    @OneToMany
    private Set<CarRental> rents;
}
