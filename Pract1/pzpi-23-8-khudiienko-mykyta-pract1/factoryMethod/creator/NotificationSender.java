package creator;

import product.Notification;

/**
 * Абстрактний клас Creator.
 * Містить базову бізнес-логіку, яка не залежить від конкретних класів сповіщень.
 */
public abstract class NotificationSender {

    /**
     * FACTORY METHOD (Фабричний метод).
     * Підкласи повинні реалізувати цей метод, щоб створювати потрібні об'єкти.
     */
    protected abstract Notification createNotification();

    /**
     * Основна бізнес-логіка, яка використовує фабричний метод.
     */
    public void processAndSend(String message, String recipient) {
        System.out.println("\n[LOG] Початок обробки сповіщення для " + recipient);
        Notification notification = createNotification();
        notification.send(message, recipient);
        System.out.println("[LOG] Сповіщення успішно відправлено та збережено в БД.");
    }
}