package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.FundiProfile;
import za.ac.cput.domain.Review;
import za.ac.cput.domain.User;

public final class ReviewFactory {

    private ReviewFactory() {
    }

    public static Review create(Booking booking, User customer, FundiProfile fundiProfile,
                                     Integer rating, String comment) {
            return Review.builder()
                    .booking(booking)
                    .customer(customer)
                    .fundiProfile(fundiProfile)
                    .rating(rating)
                    .comment(comment)
                    .build();
        }

}