package za.ac.cput.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Notification;
import za.ac.cput.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController extends BaseController<Notification> {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @Override
    protected Object getService() {
        return service;
    }

    @Override
    protected Notification createEntity(Notification entity) {
        return service.create(entity);
    }

    @Override
    protected Notification updateEntity(Notification entity) {
        return service.update(entity);
    }

    @Override
    protected Notification getEntity(Long id) {
        return service.getById(id);
    }

    @Override
    protected List<Notification> getEntities() {
        return service.getAll();
    }

    @Override
    protected void deleteEntity(Long id) {
        service.delete(id);
    }
}
