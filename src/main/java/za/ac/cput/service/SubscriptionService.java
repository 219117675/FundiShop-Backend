package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Subscription;
import za.ac.cput.repository.SubscriptionRepository;

@Service
public class SubscriptionService extends BaseService<Subscription> {

    public SubscriptionService(SubscriptionRepository repository) {
        super(repository);
    }
}
