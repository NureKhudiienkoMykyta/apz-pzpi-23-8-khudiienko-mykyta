package product;

public class EmailNotification implements Notification {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Підключення до SMTP сервера...");
        System.out.println("Відправка EMAIL на адресу [" + recipient + "]: " + message);
    }
}