package bp.biblioteka.entity.user;

import bp.biblioteka.observer.item.ItemObserver;
import bp.biblioteka.visitor.user.UserVisitor;

import java.util.UUID;

public class Customer extends User implements ItemObserver {
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

    @Override
    public String accept(UserVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public void update(String itemName, String message) {
        System.out.println(itemName + ": " + message);
    }
}
