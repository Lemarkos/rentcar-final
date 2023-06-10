package kg.lemtech.rentcarfinal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Boolean babySeat;
    Boolean withDriver;
    String clientName;
    String clientEmail;
    Integer daysCount;
    Double priceBeforeDiscount;
    Double priceWithDiscount;
    @ManyToOne
    @JoinColumn(name = "get_address_id",referencedColumnName = "id")
    Address getAddress;
    @ManyToOne
    @JoinColumn(name = "return_address_id", referencedColumnName = "id")
    Address returnAddress;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime dateFrom;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime dateTo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    Car car;
}
