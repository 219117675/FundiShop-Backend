package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.User;

public final class CartFactory {

    private CartFactory() {
    }

    public static Cart create(User user) {
            return Cart.builder()
                    .user(user)
                    .build();
        }

}