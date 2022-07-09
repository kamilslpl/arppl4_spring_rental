package pl.sda.arppl4.spring_rental.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.sda.arppl4.spring_rental.model.dto.CarDTO;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Car", description = "Encja reprezentująca instancji samochod w bazie danych.")

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

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Set<CarRental> carRentals;


    public CarDTO mapToCarDTO() {
        return new CarDTO(
                id,
                nazwa,
                marka,
                dataProdukcji,
                nadwozie,
                iloscPasazerow,
                skrzynia,
                pojemnoscSilnika
        );
    }
}
