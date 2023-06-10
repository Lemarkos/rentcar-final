package kg.lemtech.rentcarfinal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.lemtech.rentcarfinal.model.Address;
import lombok.*;

import java.time.LocalDateTime;
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    CarDTO car;
    Boolean babySeat;
    Boolean withDriver;
    String clientName;
    String clientEmail;
    Address getAddress;
    Address returnAddress;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime dateFrom;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime dateTo;
    Double priceBeforeDiscount;
    Double priceWithDiscount;
}
