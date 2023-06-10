package kg.lemtech.rentcarfinal.mapper;

import kg.lemtech.rentcarfinal.dto.CarDTO;
import kg.lemtech.rentcarfinal.model.Car;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CarMapper {
    Car toEntity(CarDTO carDTO);
    CarDTO toDTO(Car car);
    List<CarDTO>toDtoList(List<Car> cars);
}
