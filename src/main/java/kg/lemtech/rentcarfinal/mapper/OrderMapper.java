package kg.lemtech.rentcarfinal.mapper;

import kg.lemtech.rentcarfinal.dto.OrderDTO;
import kg.lemtech.rentcarfinal.model.Order;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper
public interface OrderMapper {
    Order toEntity(OrderDTO orderDTO);
    OrderDTO toDTO(Order order);
    List<OrderDTO> toDTOList(List<Order> orderList);
}
