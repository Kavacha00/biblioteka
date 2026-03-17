package bp.biblioteka.bridge.user;

import bp.biblioteka.entity.user.Employee;

public class EmployeeBuilderBridge extends DefaultEmployeeBuilder{
    private final EmployeeBuilder impl;

    public EmployeeBuilderBridge(EmployeeBuilder impl) {
        this.impl = impl;
    }

    public EmployeeBuilder name(String name) {
        this.impl.name(name);
        return this;
    }

    public EmployeeBuilder email(String email) {
        impl.email(email);
        return this;
    }

    public EmployeeBuilder login(String login) {
        impl.login(login);
        return this;
    }

    public EmployeeBuilder password(String password) {
        impl.password(password);
        return this;
    }

    public Employee build() {
        return impl.build();
    }

    public void reset() {
        impl.reset();
    }
}