package kg.lemtech.rentcarfinal.repositories;

import kg.lemtech.rentcarfinal.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
}
