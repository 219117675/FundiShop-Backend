package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.CartItem;
import za.ac.cput.repository.CartItemRepository;

@Service
public class CartItemService extends BaseService<CartItem> {

    public CartItemService(CartItemRepository repository) {
        super(repository);
    }
}
