package bp.biblioteka.factory.user;

import bp.biblioteka.entity.user.Employee;
import bp.biblioteka.entity.user.User;

public class EmployeeCreator extends UserCreator{
    @Override
    public User createUser(String name, String email, String login, String password) {
        return new Employee(name, email, login, password);
    }
}
