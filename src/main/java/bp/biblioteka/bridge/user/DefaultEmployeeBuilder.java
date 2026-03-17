package bp.biblioteka.bridge.user;

import bp.biblioteka.entity.user.Employee;

public class DefaultEmployeeBuilder implements EmployeeBuilder{
    private String name;
    private String email;
    private String login;
    private String password;

    @Override
    public EmployeeBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public EmployeeBuilder email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public EmployeeBuilder login(String login) {
        this.login = login;
        return this;
    }

    @Override
    public EmployeeBuilder password(String password) {
        this.password = password;
        return this;
    }

    @Override
    public Employee build() {
        var employee = new Employee(name, email, login, password);
        reset();
        return employee;
    }

    @Override
    public void reset() {
        name = email = login = password = null;
    }
}