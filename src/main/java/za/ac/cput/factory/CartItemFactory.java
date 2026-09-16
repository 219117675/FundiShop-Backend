package za.ac.cput.factory;

import java.math.BigDecimal;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.domain.Listing;

public final class CartItemFactory {

    private CartItemFactory() {
    }

    public static CartItem create(Cart cart, Listing listing, Booking booking,
                                        Integer quantity, BigDecimal unitPrice) {
            return CartItem.builder()
                    .cart(cart)
                    .listing(listing)
                    .booking(booking)
                    .quantity(quantity)
                    .unitPrice(unitPrice)
                    .build();
        }

}