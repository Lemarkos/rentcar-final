package kg.lemtech.rentcarfinal.controller;

import kg.lemtech.rentcarfinal.dto.OrderDTO;
import kg.lemtech.rentcarfinal.mapper.OrderMapper;
import kg.lemtech.rentcarfinal.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping("/make")
    public OrderDTO makeOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.save(orderMapper.toEntity(orderDTO));
    }
}
