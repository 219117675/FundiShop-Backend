package za.ac.cput.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Address;
import za.ac.cput.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController extends BaseController<Address> {

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @Override
    protected Object getService() {
        return service;
    }

    @Override
    protected Address createEntity(Address entity) {
        return service.create(entity);
    }

    @Override
    protected Address updateEntity(Address entity) {
        return service.update(entity);
    }

    @Override
    protected Address getEntity(Long id) {
        return service.getById(id);
    }

    @Override
    protected List<Address> getEntities() {
        return service.getAll();
    }

    @Override
    protected void deleteEntity(Long id) {
        service.delete(id);
    }
}
