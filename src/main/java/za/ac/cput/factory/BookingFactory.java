package za.ac.cput.factory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.FundiProfile;
import za.ac.cput.domain.User;

public final class BookingFactory {

    private BookingFactory() {
    }

    public static Booking create(User customer, FundiProfile fundiProfile,
                                      LocalDate scheduledDate, LocalTime scheduledTime,
                                      String jobDescription, BigDecimal calloutFee) {
            return Booking.builder()
                    .customer(customer)
                    .fundiProfile(fundiProfile)
                    .scheduledDate(scheduledDate)
                    .scheduledTime(scheduledTime)
                    .jobDescription(jobDescription)
                    .calloutFee(calloutFee)
                    .build();
        }

}