package za.ac.cput.factory;

import java.math.BigDecimal;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.RevenueTransaction;

public final class RevenueTransactionFactory {

    private RevenueTransactionFactory() {
    }

    public static RevenueTransaction create(Order order, Booking booking,
                                                       String type, BigDecimal amount) {
            return RevenueTransaction.builder()
                    .order(order)
                    .booking(booking)
                    .type(type)
                    .amount(amount)
                    .build();
        }

}