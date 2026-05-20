package bp.biblioteka.builder.user;

import bp.biblioteka.entity.user.Employee;

//Tydzień 2, Wzorzec Builder 2,
// Builder umożliwia tworzenie obiektów krok po kroku
public class EmployeeBuilder {
    private String name;
    private String email;
    private String login;
    private String password;

    public void reset() {
        this.name = null;
        this.email = null;
        this.login = null;
        this.password = null;
    }

    public EmployeeBuilder name(String name) {
        this.name = name;
        return this;
    }

    public EmployeeBuilder email(String email) {
        this.email = email;
        return this;
    }

    public EmployeeBuilder login(String login) {
        this.login = login;
        return this;
    }

    public EmployeeBuilder password(String password) {
        this.password = password;
        return this;
    }

    public Employee build() {
        var employeeName = this.name;
        var employeeEmail = this.email;
        var employeeLogin = this.login;
        var employeePassword = this.password;

        this.reset();
        return new Employee(employeeName, employeeEmail, employeeLogin, employeePassword);
    }
}
//Koniec, Tydzień 2, Wzorzec Builder 2
