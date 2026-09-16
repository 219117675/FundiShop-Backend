package za.ac.cput.factory;

import java.math.BigDecimal;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.enums.PaymentMethod;

public final class PaymentFactory {

    private PaymentFactory() {
    }

    public static Payment create(Order order, BigDecimal amount, PaymentMethod method,
                                      String transactionRef) {
            return Payment.builder()
                    .order(order)
                    .amount(amount)
                    .method(method)
                    .transactionRef(transactionRef)
                    .build();
        }

}