package kg.lemtech.rentcarfinal.service;

import kg.lemtech.rentcarfinal.model.Price;

public interface PriceService {
    void save(Price price);
    Price findById(Long id);
}
