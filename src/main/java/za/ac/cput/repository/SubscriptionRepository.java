package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
