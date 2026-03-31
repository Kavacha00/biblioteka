package bp.biblioteka.mediator.user;

import bp.biblioteka.entity.user.User;

public class UserPanel {
    private final UserMediator mediator;

    public UserPanel(UserMediator mediator) {
        this.mediator = mediator;
    }

    public void login(User user) {
        mediator.notify(this, "login", user);
    }

    public void logout(User user) {
        mediator.notify(this, "logout", user);
    }

    public void showMessage(String message) {
        System.out.println("[UserPanel] " + message);
    }

}
