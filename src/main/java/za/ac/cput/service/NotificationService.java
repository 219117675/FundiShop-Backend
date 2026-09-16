package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Notification;
import za.ac.cput.repository.NotificationRepository;

@Service
public class NotificationService extends BaseService<Notification> {

    public NotificationService(NotificationRepository repository) {
        super(repository);
    }
}
