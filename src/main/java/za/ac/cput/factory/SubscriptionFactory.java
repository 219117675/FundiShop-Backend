package za.ac.cput.factory;

import java.math.BigDecimal;
import java.time.LocalDate;
import za.ac.cput.domain.FundiProfile;
import za.ac.cput.domain.Subscription;

public final class SubscriptionFactory {

    private SubscriptionFactory() {
    }

    public static Subscription create(FundiProfile fundiProfile, String planName,
                                                       BigDecimal monthlyFee, LocalDate startDate,
                                                       LocalDate nextBillingDate) {
            return Subscription.builder()
                    .fundiProfile(fundiProfile)
                    .planName(planName)
                    .monthlyFee(monthlyFee)
                    .startDate(startDate)
                    .nextBillingDate(nextBillingDate)
                    .build();
        }

}