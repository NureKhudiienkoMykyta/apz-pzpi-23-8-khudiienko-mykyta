package creator;

import product.EmailNotification;
import product.Notification;

public class EmailNotificationSender extends NotificationSender {
    @Override
    protected Notification createNotification() {
        return new EmailNotification();
    }
}