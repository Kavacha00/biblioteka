package bp.biblioteka.entity.user;

import bp.biblioteka.flyweight.user.Role;
import bp.biblioteka.observer.user.UserObserver;
import bp.biblioteka.observer.user.UserSubject;
import bp.biblioteka.state.user.ActiveUserState;
import bp.biblioteka.state.user.BannedUserState;
import bp.biblioteka.state.user.SuspendedUserState;
import bp.biblioteka.state.user.UserState;
import bp.biblioteka.strategy.user.EmailNotificationStrategy;
import bp.biblioteka.strategy.user.NotificationStrategy;
import bp.biblioteka.visitor.user.UserVisitable;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public abstract class User implements Cloneable, UserSubject, UserVisitable {
    private UUID id;
    private boolean loggedIn = false;
    private String name;
    private String email;
    private String login;
    private String password;
    private final Set<Role> roles = new HashSet<>();

    private final List<UserObserver> observers = new ArrayList<>();
    private UserState userState = new ActiveUserState();
    private NotificationStrategy notificationStrategy = new EmailNotificationStrategy();

    public User() {}

    public User(String name, String email, String login, String password) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    protected User(UUID id, String name, String email, String login, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public abstract String logIn();
    public abstract String logOut();

    @Override
    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public void addUserObserver(UserObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeUserObserver(UserObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyUserObservers(String event) {
        for (UserObserver observer : observers) {
            observer.onUserEvent(this.getLogin(), event);
        }
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
        notifyUserObservers(loggedIn ? "USER_LOGGED_IN" : "USER_LOGGED_OUT");
    }

    public String activate() {
        String message = userState.activate();
        userState = new ActiveUserState();
        notifyUserObservers("USER_" + userState.getStateName());
        return message;
    }

    public String ban() {
        String message = userState.ban();
        userState = new BannedUserState();
        notifyUserObservers("USER_" + userState.getStateName());
        return message;
    }

    public String suspend() {
        String message = userState.suspend();
        userState = new SuspendedUserState();
        notifyUserObservers("USER_" + userState.getStateName());
        return message;
    }

    public String getStateName() {
        return userState.getStateName();
    }

    public void setNotificationStrategy(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public String getNotificationStrategyName() {
        return notificationStrategy.getStrategyName();
    }

    public String notify(String message) {
        return notificationStrategy.send(this.getEmail(), message);
    }


}
