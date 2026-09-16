package za.ac.cput.factory;

import za.ac.cput.domain.Notification;
import za.ac.cput.domain.User;

public final class NotificationFactory {

    private NotificationFactory() {
    }

    public static Notification create(User user, String message, String type) {
            return Notification.builder()
                    .user(user)
                    .message(message)
                    .type(type)
                    .build();
        }

}