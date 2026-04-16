package bp.biblioteka.strategy.user;

public class EmailNotificationStrategy implements NotificationStrategy {
    @Override
    public String send(String recipient, String message) {
        return String.format("Email sent to [%s]: %s", recipient, message);
    }

    @Override
    public String getStrategyName() { return "EMAIL"; }
}
