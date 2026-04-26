package bp.biblioteka.solid.dip.notifications;

// Tydzień 8, Zasada DIP 1
// Klasa abstrakcyjna dostarczająca bazową implementację formatowania.

public abstract class AbstractMessageSender implements MessageSender {
    protected String formatMessage(String rawMessage) {
        return "[SYSTEM BIBLIOTECZNY]: " + rawMessage;
    }
}
// Koniec, Tydzień 8, Zasada DIP 1
