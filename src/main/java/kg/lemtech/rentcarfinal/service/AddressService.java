package kg.lemtech.rentcarfinal.service;

import kg.lemtech.rentcarfinal.model.Address;

public interface AddressService {
    Address save(Address address);
    Address findById(Long id);
}
