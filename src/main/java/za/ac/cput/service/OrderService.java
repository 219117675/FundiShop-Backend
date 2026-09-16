package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.OrderRepository;

@Service
public class OrderService extends BaseService<Order> {

    public OrderService(OrderRepository repository) {
        super(repository);
    }
}
