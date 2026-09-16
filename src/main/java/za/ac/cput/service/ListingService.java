package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Listing;
import za.ac.cput.repository.ListingRepository;

@Service
public class ListingService extends BaseService<Listing> {

    public ListingService(ListingRepository repository) {
        super(repository);
    }
}
