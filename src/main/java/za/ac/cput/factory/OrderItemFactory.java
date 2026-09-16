package za.ac.cput.factory;

import java.math.BigDecimal;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Listing;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;

public final class OrderItemFactory {

    private OrderItemFactory() {
    }

    public static OrderItem create(Order order, Listing listing, Booking booking,
                                         Integer quantity, BigDecimal unitPrice) {
            BigDecimal subtotal = unitPrice.multiply(BigDecimal.valueOf(quantity));
            return OrderItem.builder()
                    .order(order)
                    .listing(listing)
                    .booking(booking)
                    .quantity(quantity)
                    .unitPrice(unitPrice)
                    .subtotal(subtotal)
                    .build();
        }

}