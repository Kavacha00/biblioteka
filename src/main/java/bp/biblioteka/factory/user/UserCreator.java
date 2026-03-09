package bp.biblioteka.factory.user;

import bp.biblioteka.entity.user.User;

public abstract class UserCreator {
    public abstract User createUser(String name, String email, String login, String password);
}
