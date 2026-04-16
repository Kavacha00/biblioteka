package bp.biblioteka.observer.user;

// Tydzień 6, Wzorzec Observer 2
// Logger wyświetlający operacje użytkowników
public class UserAuditLogger implements UserObserver {
    @Override
    public void onUserEvent(String userLogin, String event) {
        System.out.println("[AUDIT] User '" + userLogin + "' triggered: " + event);
    }
}