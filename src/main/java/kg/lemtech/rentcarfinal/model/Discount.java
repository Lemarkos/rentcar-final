package kg.lemtech.rentcarfinal.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_discounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double discount;
    Integer daysCount;
    LocalDateTime startDate;
    LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName ="id")
    Car car;
}
