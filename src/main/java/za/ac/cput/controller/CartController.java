package za.ac.cput.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Cart;
import za.ac.cput.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController extends BaseController<Cart> {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @Override
    protected Object getService() {
        return service;
    }

    @Override
    protected Cart createEntity(Cart entity) {
        return service.create(entity);
    }

    @Override
    protected Cart updateEntity(Cart entity) {
        return service.update(entity);
    }

    @Override
    protected Cart getEntity(Long id) {
        return service.getById(id);
    }

    @Override
    protected List<Cart> getEntities() {
        return service.getAll();
    }

    @Override
    protected void deleteEntity(Long id) {
        service.delete(id);
    }
}
