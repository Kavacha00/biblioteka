package bp.biblioteka.interpreter.user;

import bp.biblioteka.entity.user.User;

public interface Expression {
    void interpret(User user);
}
