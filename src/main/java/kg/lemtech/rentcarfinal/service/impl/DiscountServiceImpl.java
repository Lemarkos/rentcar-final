package kg.lemtech.rentcarfinal.service.impl;

import kg.lemtech.rentcarfinal.model.Discount;
import kg.lemtech.rentcarfinal.repositories.DiscountRepo;
import kg.lemtech.rentcarfinal.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepo discountRepo;
    @Override
    public Discount save(Discount discount) {
        return discountRepo.save(discount);
    }

    @Override
    public Discount findById(Long id) {
        return discountRepo.findById(id).orElse(null);
    }

    @Override
    public List<Discount> findAllByCarIdAndDaysCountLessThanEqualOrderByDaysCountDesc(Long id, Integer count) {
        return discountRepo.findAllByCarIdAndDaysCountLessThanEqualOrderByDaysCountDesc(id, count);
    }
}
