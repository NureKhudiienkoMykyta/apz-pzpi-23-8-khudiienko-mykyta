package product;

public class PushNotification implements Notification {
    @Override
    public void send(String message, String recipient) {
        // Підключення до Firebase Cloud Messaging (FCM) або APNs
        System.out.println("Встановлення з'єднання з Firebase...");
        System.out.println("Відправка PUSH-повідомлення на пристрій [" + recipient + "]: " + message);
    }
}