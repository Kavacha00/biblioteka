package bp.biblioteka.decorator.user;

import bp.biblioteka.entity.user.User;

public class FirstTimeLoginDecorator extends UserDecorator {
    public FirstTimeLoginDecorator(User user) {
        super(user);
    }

    @Override
    public String logIn() {
        return super.logIn() + " for the first time";
    }
}
