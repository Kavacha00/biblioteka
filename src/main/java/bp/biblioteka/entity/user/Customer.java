package bp.biblioteka.entity.user;

public class Customer extends User {
    public Customer(String name, String email, String login, String password) {
        super(name, email, login, password);
    }

    @Override
    public String logIn() {
        return "Customer logged in";
    }

    @Override
    public String logOut() {
        return "Customer logged out";
    }
}
