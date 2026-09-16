package za.ac.cput.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Review;
import za.ac.cput.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController extends BaseController<Review> {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @Override
    protected Object getService() {
        return service;
    }

    @Override
    protected Review createEntity(Review entity) {
        return service.create(entity);
    }

    @Override
    protected Review updateEntity(Review entity) {
        return service.update(entity);
    }

    @Override
    protected Review getEntity(Long id) {
        return service.getById(id);
    }

    @Override
    protected List<Review> getEntities() {
        return service.getAll();
    }

    @Override
    protected void deleteEntity(Long id) {
        service.delete(id);
    }
}
