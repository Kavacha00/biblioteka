package bp.biblioteka.entity.user;

import java.util.UUID;

public class Employee extends User {
    public Employee(String name, String email, String login, String password) {
        super(name, email, login, password);
    }

    private Employee(UUID id, String name, String email, String login, String password) {
        super(id, name, email, login, password);
    }

    @Override
    public String logIn() {
        this.setLoggedIn(true);
        return "Employee logged in";
    }

    @Override
    public String logOut() {
        this.setLoggedIn(false);
        return "Employee logged out";
    }

}
