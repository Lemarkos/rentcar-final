package kg.lemtech.rentcarfinal.service;

import kg.lemtech.rentcarfinal.model.Discount;

import java.util.List;

public interface DiscountService {
    Discount save(Discount discount);
    Discount findById(Long id);
    List<Discount>findAllByCarIdAndDaysCountLessThanEqualOrderByDaysCountDesc(Long id,Integer count);
}
