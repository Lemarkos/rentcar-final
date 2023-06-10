package kg.lemtech.rentcarfinal.repositories;

import kg.lemtech.rentcarfinal.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
    List<Order> findAllByDateToLessThanEqual(LocalDateTime endDate);
}
