package product;

/**
 * Інтерфейс Product. 
 * Визначає загальну поведінку для всіх типів сповіщень.
 */
public interface Notification {
    void send(String message, String recipient);
}