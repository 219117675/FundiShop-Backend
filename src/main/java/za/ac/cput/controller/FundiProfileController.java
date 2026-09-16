package za.ac.cput.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.FundiProfile;
import za.ac.cput.service.FundiProfileService;

import java.util.List;

@RestController
@RequestMapping("/api/fundiprofiles")
public class FundiProfileController extends BaseController<FundiProfile> {

    private final FundiProfileService service;

    public FundiProfileController(FundiProfileService service) {
        this.service = service;
    }

    @Override
    protected Object getService() {
        return service;
    }

    @Override
    protected FundiProfile createEntity(FundiProfile entity) {
        return service.create(entity);
    }

    @Override
    protected FundiProfile updateEntity(FundiProfile entity) {
        return service.update(entity);
    }

    @Override
    protected FundiProfile getEntity(Long id) {
        return service.getById(id);
    }

    @Override
    protected List<FundiProfile> getEntities() {
        return service.getAll();
    }

    @Override
    protected void deleteEntity(Long id) {
        service.delete(id);
    }

    @GetMapping("/user/{userId}")
    public FundiProfile getByUserId(@PathVariable Long userId) {
        return service.getByUserId(userId);
    }
}
