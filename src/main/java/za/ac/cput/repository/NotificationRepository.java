package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
