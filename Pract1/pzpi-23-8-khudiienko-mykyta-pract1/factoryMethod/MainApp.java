import creator.EmailNotificationSender;
import creator.NotificationSender;
import creator.PushNotificationSender;
import creator.SmsNotificationSender;

public class MainApp {
    public static void main(String[] args) {

        // Сценарій 1: Користувач щойно зареєструвався (потрібен Email)
        NotificationSender emailService = new EmailNotificationSender();
        emailService.processAndSend("Вітаємо на нашій платформі!", "user@gmail.com");

        // Сценарій 2: Двофакторна автентифікація (потрібна SMS)
        NotificationSender smsService = new SmsNotificationSender();
        smsService.processAndSend("Ваш код підтвердження: 481516", "+380501234567");
        // Сценарій 3: Акція в мобільному додатку (потрібен Push)
        NotificationSender pushService = new PushNotificationSender();
        pushService.processAndSend("Знижка 20% на всі товари!", "device_token_xyz987");
    }
}