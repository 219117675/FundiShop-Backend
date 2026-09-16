package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.repository.OrderItemRepository;

@Service
public class OrderItemService extends BaseService<OrderItem> {

    public OrderItemService(OrderItemRepository repository) {
        super(repository);
    }
}
