package creator;

import product.Notification;
import product.PushNotification;

public class PushNotificationSender extends NotificationSender {
    @Override
    protected Notification createNotification() {
        return new PushNotification();
    }
}