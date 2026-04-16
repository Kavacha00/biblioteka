package bp.biblioteka.template.user;

import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.User;
import bp.biblioteka.flyweight.user.RoleFactory;

public class CustomerRegistration  extends UserRegistrationTemplate {
    @Override
    protected User createUser(String name, String email, String login, String password) {
        return new Customer(name, email, login, password);
    }

    @Override
    protected void assignRole(User user) {
        user.getRoles().add(RoleFactory.getRole("CUSTOMER"));
    }

    @Override
    protected void notifyRegistration(User user) {
        System.out.println("Welcome, " + user.getName() + "! Enjoy shopping with us.");
    }
}
