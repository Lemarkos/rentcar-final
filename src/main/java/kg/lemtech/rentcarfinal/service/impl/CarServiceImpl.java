package kg.lemtech.rentcarfinal.service.impl;

import kg.lemtech.rentcarfinal.model.Car;
import kg.lemtech.rentcarfinal.repositories.CarRepo;
import kg.lemtech.rentcarfinal.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepo carRepo;
    @Override
    public Car save(Car car) {
        return carRepo.save(car);
    }

    @Override
    public Car findById(Long id) {
        return carRepo.findById(id).orElse(null);
    }

    @Override
    public List<Car> findAll() {
        return carRepo.findAll();
    }

    @Override
    public List<Car> findByIsAvailable(Boolean isAvailable) {
        return carRepo.findByIsAvailableTrue(isAvailable);
    }

    @Override
    public List<Car> findByIsUnavailable(Boolean isUnavailable) {
        return carRepo.findByIsAvailableFalse(isUnavailable);
    }
}
