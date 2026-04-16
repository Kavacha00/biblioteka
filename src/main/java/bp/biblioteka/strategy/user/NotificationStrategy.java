package bp.biblioteka.strategy.user;

// Tydzień 6, Wzorzec Strategy 2
// Wzorzec Strategy definiujący wspólny interfejs dla metod powiadamiania użytkownika
public interface NotificationStrategy {
    String send(String recipient, String message);
    String getStrategyName();
}
