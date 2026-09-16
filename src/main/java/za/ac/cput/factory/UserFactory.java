package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.domain.enums.Role;

public final class UserFactory {

    private UserFactory() {
    }

    public static User create(String fullName, String email, String password, String phone, Role role) {
            return User.builder()
                    .fullName(fullName)
                    .email(email)
                    .password(password)
                    .phone(phone)
                    .role(role)
                    .build();
        }

}