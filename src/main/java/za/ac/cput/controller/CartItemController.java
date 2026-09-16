package za.ac.cput.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.CartItem;
import za.ac.cput.service.CartItemService;

import java.util.List;

@RestController
@RequestMapping("/api/cartitems")
public class CartItemController extends BaseController<CartItem> {

    private final CartItemService service;

    public CartItemController(CartItemService service) {
        this.service = service;
    }

    @Override
    protected Object getService() {
        return service;
    }

    @Override
    protected CartItem createEntity(CartItem entity) {
        return service.create(entity);
    }

    @Override
    protected CartItem updateEntity(CartItem entity) {
        return service.update(entity);
    }

    @Override
    protected CartItem getEntity(Long id) {
        return service.getById(id);
    }

    @Override
    protected List<CartItem> getEntities() {
        return service.getAll();
    }

    @Override
    protected void deleteEntity(Long id) {
        service.delete(id);
    }
}
