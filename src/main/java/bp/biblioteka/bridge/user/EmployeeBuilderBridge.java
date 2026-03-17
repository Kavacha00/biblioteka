package bp.biblioteka.bridge.user;

import bp.biblioteka.entity.user.Employee;

//Tydzień 3, Wzorzec Bridge 2,
// Wzorzec Bridge oddziela abstrakcję (EmployeeBuilder) od implementacji (DefaultEmployeeBuilder),
// dzięki czemu można podmieniać implementacje buildera (np dodać wymagania biznesowe do pól).
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
//Koniec, Tydzień 3, Wzorzec Bridge 2