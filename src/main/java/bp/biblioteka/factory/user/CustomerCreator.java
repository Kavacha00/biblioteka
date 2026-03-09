package bp.biblioteka.factory.user;

import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.User;

public class CustomerCreator extends UserCreator {
    @Override
    public User createUser(String name, String email, String login, String password) {
        return new Customer(name, email, login, password);
    }
}
