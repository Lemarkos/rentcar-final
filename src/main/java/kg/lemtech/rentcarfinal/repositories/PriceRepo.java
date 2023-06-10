package kg.lemtech.rentcarfinal.repositories;

import kg.lemtech.rentcarfinal.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepo extends JpaRepository<Price,Long> {
}
