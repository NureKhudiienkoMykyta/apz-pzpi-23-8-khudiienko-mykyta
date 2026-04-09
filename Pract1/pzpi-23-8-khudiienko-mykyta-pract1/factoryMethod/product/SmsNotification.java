package product;

public class SmsNotification implements Notification {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Автентифікація в SMS Gateway...");
        System.out.println("Відправка SMS на номер [" + recipient + "]: " + message);
    }
}