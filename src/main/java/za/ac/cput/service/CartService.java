package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.repository.CartRepository;

@Service
public class CartService extends BaseService<Cart> {

    public CartService(CartRepository repository) {
        super(repository);
    }
}
