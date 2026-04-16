package bp.biblioteka.strategy.user;

public class SmsNotificationStrategy implements NotificationStrategy {
    @Override
    public String send(String recipient, String message) {
        return String.format("SMS sent to [%s]: %s", recipient, message);
    }

    @Override
    public String getStrategyName() { return "SMS"; }
}
