package bp.biblioteka.entity.user;

import bp.biblioteka.visitor.user.UserVisitor;

import java.util.UUID;

// Tydzień 8, Zasada LSP 1
// Implementacja klasy pochodnej Employee zachowująca kontrakt klasy bazowej User.
// Klasa realizuje metody logowania zgodnie z oczekiwaniami systemu, umożliwiając bezpieczne podstawienie.

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

    @Override
    public String accept(UserVisitor visitor) {
        return visitor.visit(this);
    }

}

// Koniec, Tydzień 8, Zasada LSP 1