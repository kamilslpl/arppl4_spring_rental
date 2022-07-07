package pl.sda.arppl4.spring_rental.model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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
    @CreationTimestamp
    private LocalDateTime czasWynajmu;
    private LocalDateTime czasZwrotu;
    private Double cenaNajmu;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Car car;


}

