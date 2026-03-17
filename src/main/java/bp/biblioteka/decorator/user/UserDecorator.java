package bp.biblioteka.decorator.user;

import bp.biblioteka.entity.user.User;

public class UserDecorator extends User {
    private final User user;

    public UserDecorator(User user) {
        this.user = user;
    }

    @Override
    public String logIn() {
        return user.logIn();
    }

    @Override
    public String logOut() {
        return user.logOut();
    }
}
