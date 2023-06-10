package kg.lemtech.rentcarfinal.service.impl;

import kg.lemtech.rentcarfinal.model.Price;
import kg.lemtech.rentcarfinal.repositories.PriceRepo;
import kg.lemtech.rentcarfinal.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
    private final PriceRepo priceRepo;
    @Override
    public void save(Price price) {
        price.setStartDate(LocalDateTime.now());
        price.setEndDate(LocalDateTime.now().plusYears(10));
        priceRepo.save(price);
    }

    @Override
    public Price findById(Long id) {
        return priceRepo.findById(id).orElse(null);
    }
}
