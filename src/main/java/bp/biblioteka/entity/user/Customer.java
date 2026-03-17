package bp.biblioteka.entity.user;

import java.util.UUID;

public class Customer extends User {
    public Customer(String name, String email, String login, String password) {
        super(name, email, login, password);
    }

    private Customer(UUID id, String name, String email, String login, String password) {
        super(id, name, email, login, password);
    }

    @Override
    public String logIn() {
        this.setLoggedIn(true);
        return "Customer logged in";
    }

    @Override
    public String logOut() {
        this.setLoggedIn(false);
        return "Customer logged out";
    }
}
