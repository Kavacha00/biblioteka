package bp.biblioteka.strategy.user;

import bp.biblioteka.visitor.user.UserVisitable;

public class PushNotificationStrategy implements NotificationStrategy {
    @Override
    public String send(String recipient, String message) {
        return String.format("Push notification sent to [%s]: %s", recipient, message);
    }

    @Override
    public String getStrategyName() { return "PUSH"; }
}
