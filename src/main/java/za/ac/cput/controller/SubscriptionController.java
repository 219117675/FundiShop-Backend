package za.ac.cput.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Subscription;
import za.ac.cput.service.SubscriptionService;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController extends BaseController<Subscription> {

    private final SubscriptionService service;

    public SubscriptionController(SubscriptionService service) {
        this.service = service;
    }

    @Override
    protected Object getService() {
        return service;
    }

    @Override
    protected Subscription createEntity(Subscription entity) {
        return service.create(entity);
    }

    @Override
    protected Subscription updateEntity(Subscription entity) {
        return service.update(entity);
    }

    @Override
    protected Subscription getEntity(Long id) {
        return service.getById(id);
    }

    @Override
    protected List<Subscription> getEntities() {
        return service.getAll();
    }

    @Override
    protected void deleteEntity(Long id) {
        service.delete(id);
    }
}
