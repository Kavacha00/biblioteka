package bp.biblioteka.observer.user;

public interface UserObserver {
    void onUserEvent(String userLogin, String event);
}
