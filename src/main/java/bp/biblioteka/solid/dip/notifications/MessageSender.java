package bp.biblioteka.solid.dip.notifications;

// Tydzień 8, Zasada DIP 1
// Interfejs stanowiący abstrakcję dla systemu powiadomień.

public interface MessageSender {
    void sendMessage(String recipient, String message);
}
// Koniec, Tydzień 8, Zasada DIP 1