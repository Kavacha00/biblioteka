package bp.biblioteka.solid.dip.notifications;

// Tydzień 8, Zasada DIP 1
// Wysokopoziomowy moduł zależący od abstrakcji (MessageSender),
// a nie od konkretnej implementacji.

public class OrderNotificationService {
    private final MessageSender sender;

    public OrderNotificationService(MessageSender sender) {
        this.sender = sender;
    }

    public void notifyCustomer(String contactData, String message) {
        sender.sendMessage(contactData, message);
    }
}
// Koniec, Tydzień 8, Zasada DIP 1