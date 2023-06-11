package kg.lemtech.rentcarfinal.model;

import kg.lemtech.rentcarfinal.model.enums.Category;
import kg.lemtech.rentcarfinal.model.enums.Color;
import kg.lemtech.rentcarfinal.model.enums.EngineType;
import kg.lemtech.rentcarfinal.model.enums.Transmission;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String model;
    String photo;
    String description;
    Integer mnfYear;
    Double engineV;
    Double consumptionPer100;
    @Enumerated(value = EnumType.STRING)
    Color color;
    @Enumerated(value = EnumType.STRING)
    EngineType engineType;
    @Enumerated(value = EnumType.STRING)
    Transmission transmission;
    @Enumerated(value = EnumType.STRING)
    Category category;
    @Column(name = "is_available", columnDefinition = "boolean default true")
    Boolean isAvailable = true;
    @ManyToOne
    @JoinColumn(name = "price_id",referencedColumnName = "id")
    Price price;
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Order> orders;
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    List<Discount> discounts;
}
