package kg.lemtech.rentcarfinal.service;

import kg.lemtech.rentcarfinal.dto.OrderDTO;
import kg.lemtech.rentcarfinal.model.Order;

import java.util.List;

public interface OrderService {
    OrderDTO save(Order order);
    Order update(Order order);
    void delete(Long id);
    Order findById(Long id);
    List<Order> findAll();
}
