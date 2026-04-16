package bp.biblioteka.observer.user;

public interface UserSubject {
    void addUserObserver(UserObserver o);
    void removeUserObserver(UserObserver o);
    void notifyUserObservers(String event);
}
