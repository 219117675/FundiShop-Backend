package za.ac.cput.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.service.OrderItemService;

import java.util.List;

@RestController
@RequestMapping("/api/orderitems")
public class OrderItemController extends BaseController<OrderItem> {

    private final OrderItemService service;

    public OrderItemController(OrderItemService service) {
        this.service = service;
    }

    @Override
    protected Object getService() {
        return service;
    }

    @Override
    protected OrderItem createEntity(OrderItem entity) {
        return service.create(entity);
    }

    @Override
    protected OrderItem updateEntity(OrderItem entity) {
        return service.update(entity);
    }

    @Override
    protected OrderItem getEntity(Long id) {
        return service.getById(id);
    }

    @Override
    protected List<OrderItem> getEntities() {
        return service.getAll();
    }

    @Override
    protected void deleteEntity(Long id) {
        service.delete(id);
    }
}
