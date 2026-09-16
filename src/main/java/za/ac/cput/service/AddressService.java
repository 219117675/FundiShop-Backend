package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;

@Service
public class AddressService extends BaseService<Address> {

    public AddressService(AddressRepository repository) {
        super(repository);
    }
}
