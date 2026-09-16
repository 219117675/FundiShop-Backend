package za.ac.cput.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Storefront;
import za.ac.cput.service.StorefrontService;

import java.util.List;

@RestController
@RequestMapping("/api/storefronts")
public class StorefrontController extends BaseController<Storefront> {

    private final StorefrontService service;

    public StorefrontController(StorefrontService service) {
        this.service = service;
    }

    @Override
    protected Object getService() {
        return service;
    }

    @Override
    protected Storefront createEntity(Storefront entity) {
        return service.create(entity);
    }

    @Override
    protected Storefront updateEntity(Storefront entity) {
        return service.update(entity);
    }

    @Override
    protected Storefront getEntity(Long id) {
        return service.getById(id);
    }

    @Override
    protected List<Storefront> getEntities() {
        return service.getAll();
    }

    @Override
    protected void deleteEntity(Long id) {
        service.delete(id);
    }
}
