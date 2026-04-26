package bp.biblioteka.solid.dip.notifications;

// Tydzień 8, Zasada DIP 1
// Konkretna implementacja (niskopoziomowa) wysyłania SMS.

public class SmsSender extends AbstractMessageSender {
    @Override
    public void sendMessage(String recipient, String message) {
        String formatted = formatMessage(message);
        System.out.println("Wysyłanie SMS na numer " + recipient + " o treści: " + formatted);
    }
}
// Koniec, Tydzień 8, Zasada DIP 1
