package pl.sda.arppl4.spring_rental.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CarRental {
    ///
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    ///

    private String clientName;
    private String clientSurname;

    @CreationTimestamp
    private LocalDateTime rentDateTime;
    private LocalDateTime returnDateTime;

    private Double price;

    @ManyToOne()
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private Car car;

    public CarRental(String clientName, String clientSurname, Double price) {
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.price = price;
    }
}