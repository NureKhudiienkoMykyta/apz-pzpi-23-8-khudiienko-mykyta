package creator;

import product.Notification;
import product.SmsNotification;

public class SmsNotificationSender extends NotificationSender {
    @Override
    protected Notification createNotification() {
        return new SmsNotification();
    }
}