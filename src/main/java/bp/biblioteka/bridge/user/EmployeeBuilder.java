package bp.biblioteka.bridge.user;

import bp.biblioteka.entity.user.Employee;

public interface EmployeeBuilder {
    EmployeeBuilder name(String name);
    EmployeeBuilder email(String email);
    EmployeeBuilder login(String login);
    EmployeeBuilder password(String password);

    Employee build();
    void reset();
}