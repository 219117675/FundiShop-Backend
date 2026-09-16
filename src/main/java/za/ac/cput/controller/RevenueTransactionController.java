package za.ac.cput.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.RevenueTransaction;
import za.ac.cput.service.RevenueTransactionService;

import java.util.List;

@RestController
@RequestMapping("/api/revenuetransactions")
public class RevenueTransactionController extends BaseController<RevenueTransaction> {

    private final RevenueTransactionService service;

    public RevenueTransactionController(RevenueTransactionService service) {
        this.service = service;
    }

    @Override
    protected Object getService() {
        return service;
    }

    @Override
    protected RevenueTransaction createEntity(RevenueTransaction entity) {
        return service.create(entity);
    }

    @Override
    protected RevenueTransaction updateEntity(RevenueTransaction entity) {
        return service.update(entity);
    }

    @Override
    protected RevenueTransaction getEntity(Long id) {
        return service.getById(id);
    }

    @Override
    protected List<RevenueTransaction> getEntities() {
        return service.getAll();
    }

    @Override
    protected void deleteEntity(Long id) {
        service.delete(id);
    }
}
