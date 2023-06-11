package kg.lemtech.rentcarfinal.service.impl;

import kg.lemtech.rentcarfinal.dto.OrderDTO;
import kg.lemtech.rentcarfinal.exceptions.CarIsRentedException;
import kg.lemtech.rentcarfinal.mapper.OrderMapper;
import kg.lemtech.rentcarfinal.model.Address;
import kg.lemtech.rentcarfinal.model.Car;
import kg.lemtech.rentcarfinal.model.Discount;
import kg.lemtech.rentcarfinal.model.Order;
import kg.lemtech.rentcarfinal.repositories.OrderRepo;
import kg.lemtech.rentcarfinal.service.AddressService;
import kg.lemtech.rentcarfinal.service.CarService;
import kg.lemtech.rentcarfinal.service.DiscountService;
import kg.lemtech.rentcarfinal.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final CarService carService;
    private final DiscountService discountService;
    private final AddressService addressService;
    private final OrderMapper orderMapper;

    @Override
    public OrderDTO save(Order order) {
        Car car = carService.findById(order.getCar().getId());
        Address getAddress = addressService.findById(order.getGetAddress().getId());
        Address returnAddress = addressService.findById(order.getReturnAddress().getId());
        order.setCar(car);
        order.setGetAddress(getAddress);
        order.setReturnAddress(returnAddress);
        order.setDaysCount(betweenDays(order));
        order.setPriceBeforeDiscount(order.getDaysCount() * car.getPrice().getPrice());
        order.setPriceWithDiscount(getPriceWithDiscount(order,car));
        if (Boolean.FALSE.equals(car.getIsAvailable())){
            throw new CarIsRentedException("Car is not available now");
        }
        car.setIsAvailable(false);
        orderRepo.save(order);
        return orderMapper.toDTO(order);
    }
//  метод рассчитывает цену со скидкой
    private double getPriceWithDiscount(Order order, Car car) {
        double discount = getDiscountById(car.getId(), order.getDaysCount());
        double priceBeforeDiscount = order.getPriceBeforeDiscount();
        double discountAmount = priceBeforeDiscount * (discount / 100);
        return priceBeforeDiscount - discountAmount;
    }
//  находит нужную скидку по id машины
    private double getDiscountById(Long id, int daysCount) {
        List<Discount> discountList = discountService.findAllByCarIdAndDaysCountLessThanEqualOrderByDaysCountDesc(id,daysCount);
        if (!discountList.isEmpty()) {
            Discount discount = discountList.get(0);
            return discount.getDiscount();
        } else {
            return 0;
        }
    }
//  возвращает промежуток в днях между  двумя датами
    private int betweenDays(Order order) {
        Duration duration = Duration.between(order.getDateFrom(), order.getDateTo());
        return (int) duration.toDays();
    }

    @Override
    public Order update(Order order) {
        Order updated = orderRepo.findById(order.getId()).orElseThrow();
        updated.setDateFrom(order.getDateFrom() == null ? updated.getDateFrom() : order.getDateFrom());
        updated.setDateFrom(order.getDateTo() == null ? updated.getDateTo() : order.getDateTo());
        return orderRepo.save(updated);
    }

    @Override
    public void delete(Long id) {
        orderRepo.deleteById(id);
    }

    @Override
    public Order findById(Long id) {
        return orderRepo.findById(id).orElse(null);
    }

    @Override
    public List<Order> findAll() {
        return orderRepo.findAll();
    }
}
