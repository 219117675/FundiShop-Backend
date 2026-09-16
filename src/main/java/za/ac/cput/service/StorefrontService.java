package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Storefront;
import za.ac.cput.repository.StorefrontRepository;

@Service
public class StorefrontService extends BaseService<Storefront> {

    public StorefrontService(StorefrontRepository repository) {
        super(repository);
    }
}
