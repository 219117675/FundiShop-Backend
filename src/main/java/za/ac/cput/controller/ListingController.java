package za.ac.cput.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Listing;
import za.ac.cput.service.ListingService;

import java.util.List;

@RestController
@RequestMapping("/api/listings")
public class ListingController extends BaseController<Listing> {

    private final ListingService service;

    public ListingController(ListingService service) {
        this.service = service;
    }

    @Override
    protected Object getService() {
        return service;
    }

    @Override
    protected Listing createEntity(Listing entity) {
        return service.create(entity);
    }

    @Override
    protected Listing updateEntity(Listing entity) {
        return service.update(entity);
    }

    @Override
    protected Listing getEntity(Long id) {
        return service.getById(id);
    }

    @Override
    protected List<Listing> getEntities() {
        return service.getAll();
    }

    @Override
    protected void deleteEntity(Long id) {
        service.delete(id);
    }
}
