package pl.sda.arppl4.spring_rental.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
    private String producent;
    private Double pojemnoscSilnika;
}
