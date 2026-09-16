package za.ac.cput.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController extends BaseController<Payment> {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @Override
    protected Object getService() {
        return service;
    }

    @Override
    protected Payment createEntity(Payment entity) {
        return service.create(entity);
    }

    @Override
    protected Payment updateEntity(Payment entity) {
        return service.update(entity);
    }

    @Override
    protected Payment getEntity(Long id) {
        return service.getById(id);
    }

    @Override
    protected List<Payment> getEntities() {
        return service.getAll();
    }

    @Override
    protected void deleteEntity(Long id) {
        service.delete(id);
    }
}
