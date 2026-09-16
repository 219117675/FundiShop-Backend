package za.ac.cput.factory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.User;
import za.ac.cput.domain.enums.PaymentMethod;

public final class OrderFactory {

    private OrderFactory() {
    }

    public static Order create(User customer, List<OrderItem> items,
                                      PaymentMethod paymentMethod, BigDecimal totalAmount) {
            return Order.builder()
                    .customer(customer)
                    .items(items == null ? new ArrayList<>() : items)
                    .paymentMethod(paymentMethod)
                    .totalAmount(totalAmount)
                    .build();
        }

}