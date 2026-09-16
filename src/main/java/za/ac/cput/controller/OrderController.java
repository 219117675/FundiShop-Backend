package za.ac.cput.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Order;
import za.ac.cput.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController extends BaseController<Order> {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @Override
    protected Object getService() {
        return service;
    }

    @Override
    protected Order createEntity(Order entity) {
        return service.create(entity);
    }

    @Override
    protected Order updateEntity(Order entity) {
        return service.update(entity);
    }

    @Override
    protected Order getEntity(Long id) {
        return service.getById(id);
    }

    @Override
    protected List<Order> getEntities() {
        return service.getAll();
    }

    @Override
    protected void deleteEntity(Long id) {
        service.delete(id);
    }
}
