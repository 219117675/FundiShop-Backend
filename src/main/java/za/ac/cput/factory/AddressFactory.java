package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.User;

public final class AddressFactory {

    private AddressFactory() {
    }

    public static Address create(User user, String line1, String suburb, String city,
                                      String postalCode, Double latitude, Double longitude) {
            return Address.builder()
                    .user(user)
                    .line1(line1)
                    .suburb(suburb)
                    .city(city)
                    .postalCode(postalCode)
                    .latitude(latitude)
                    .longitude(longitude)
                    .build();
        }

}