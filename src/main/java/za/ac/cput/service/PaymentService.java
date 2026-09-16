package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.PaymentRepository;

@Service
public class PaymentService extends BaseService<Payment> {

    public PaymentService(PaymentRepository repository) {
        super(repository);
    }
}
