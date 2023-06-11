package kg.lemtech.rentcarfinal.controller;

import kg.lemtech.rentcarfinal.dto.CarDTO;
import kg.lemtech.rentcarfinal.mapper.CarMapper;
import kg.lemtech.rentcarfinal.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    @GetMapping("/findById")
    public CarDTO findById(@RequestParam Long id) {
        return carMapper.toDTO(carService.findById(id));
    }

    @GetMapping("/findAll")
    public List<CarDTO> findAll() {
        return carMapper.toDtoList(carService.findAll());
    }

    @GetMapping("/showUnavailable")
    public List<CarDTO> showUnavailable(boolean showUnavailable) {
        return carMapper.toDtoList(carService.findByIsUnavailable(showUnavailable));
    }

    @GetMapping("/showAvailable")
    public List<CarDTO> showAvailable(boolean showAvailable) {
        return carMapper.toDtoList(carService.findByIsAvailable(showAvailable));
    }
}
