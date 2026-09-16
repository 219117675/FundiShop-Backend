package za.ac.cput.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.User;
import za.ac.cput.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController extends BaseController<User> {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @Override
    protected Object getService() {
        return service;
    }

    @Override
    protected User createEntity(User entity) {
        return service.create(entity);
    }

    @Override
    protected User updateEntity(User entity) {
        return service.update(entity);
    }

    @Override
    protected User getEntity(Long id) {
        return service.getById(id);
    }

    @Override
    protected List<User> getEntities() {
        return service.getAll();
    }

    @Override
    protected void deleteEntity(Long id) {
        service.delete(id);
    }
}
