package kg.lemtech.rentcarfinal.service;

import kg.lemtech.rentcarfinal.model.Car;

import java.util.List;

public interface CarService {
    Car save(Car car);
    Car findById(Long id);
    List<Car> findAll();
    List<Car> findByIsAvailable(Boolean isAvailable);
    List<Car> findByIsUnavailable(Boolean isUnavailable);
}
