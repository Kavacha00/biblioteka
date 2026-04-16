package bp.biblioteka.template.user;

import bp.biblioteka.entity.user.Employee;
import bp.biblioteka.entity.user.User;
import bp.biblioteka.flyweight.user.RoleFactory;

public class EmployeeRegistration extends UserRegistrationTemplate {
    @Override
    protected User createUser(String name, String email, String login, String password) {
        return new Employee(name, email, login, password);
    }

    @Override
    protected void assignRole(User user) {
        user.getRoles().add(RoleFactory.getRole("EMPLOYEE"));
    }

    @Override
    protected void notifyRegistration(User user) {
        System.out.println("Welcome, " + user.getName() + "! Your employee account is ready.");
    }
}
