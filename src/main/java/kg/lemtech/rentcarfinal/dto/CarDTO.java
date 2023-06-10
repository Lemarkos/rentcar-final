package kg.lemtech.rentcarfinal.dto;

import kg.lemtech.rentcarfinal.model.enums.Category;
import kg.lemtech.rentcarfinal.model.enums.Color;
import kg.lemtech.rentcarfinal.model.enums.EngineType;
import kg.lemtech.rentcarfinal.model.enums.Transmission;
import lombok.Data;

@Data
public class CarDTO {
    Long id;
    String model;
    String photo;
    String description;
    Integer mnfYear;
    Double engineV;
    Color color;
    EngineType engineType;
    Transmission transmission;
    Double consumptionPer100;
    Category category;
}
