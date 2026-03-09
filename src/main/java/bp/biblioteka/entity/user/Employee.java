package bp.biblioteka.entity.user;

public class Employee extends User {
    public Employee(String name, String email, String login, String password) {
        super(name, email, login, password);
    }

    @Override
    public String logIn() {
        return "User logged in";
    }

    @Override
    public String logOut() {
        return "User logged out";
    }
}
