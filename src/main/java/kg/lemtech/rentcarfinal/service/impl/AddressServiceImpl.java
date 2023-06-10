package kg.lemtech.rentcarfinal.service.impl;

import kg.lemtech.rentcarfinal.model.Address;
import kg.lemtech.rentcarfinal.repositories.AddressRepo;
import kg.lemtech.rentcarfinal.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;
    @Override
    public Address save(Address address) {
        return addressRepo.save(address);
    }

    @Override
    public Address findById(Long id) {
        return addressRepo.findById(id).orElse(null);
    }
}
