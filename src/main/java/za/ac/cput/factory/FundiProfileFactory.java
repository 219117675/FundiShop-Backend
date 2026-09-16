package za.ac.cput.factory;

import java.math.BigDecimal;
import za.ac.cput.domain.FundiProfile;
import za.ac.cput.domain.User;
import za.ac.cput.domain.enums.TradeCategory;

public final class FundiProfileFactory {

    private FundiProfileFactory() {
    }

    public static FundiProfile create(User user, TradeCategory tradeCategory, String bio,
                                            BigDecimal calloutFee, BigDecimal hourlyRate,
                                            Integer serviceAreaRadiusKm) {
            return FundiProfile.builder()
                    .user(user)
                    .tradeCategory(tradeCategory)
                    .bio(bio)
                    .calloutFee(calloutFee)
                    .hourlyRate(hourlyRate)
                    .serviceAreaRadiusKm(serviceAreaRadiusKm)
                    .build();
        }

}