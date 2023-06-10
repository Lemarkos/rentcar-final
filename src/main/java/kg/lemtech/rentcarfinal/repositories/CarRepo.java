package kg.lemtech.rentcarfinal.repositories;

import kg.lemtech.rentcarfinal.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
    @Query(value = "SElECT * FROM tb_cars WHERE is_available=false", nativeQuery = true)
    List<Car> findByIsAvailableFalse(Boolean isAvailable);
    @Query(value = "SElECT * FROM tb_cars WHERE is_available=true", nativeQuery = true)
    List<Car> findByIsAvailableTrue(Boolean isAvailable);
}
