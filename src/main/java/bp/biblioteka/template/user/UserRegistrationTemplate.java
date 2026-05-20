package bp.biblioteka.template.user;

import bp.biblioteka.entity.user.User;

//Tydzień 6, Wzorzec Template 2
//proces rejestracji użytkownika
public abstract class UserRegistrationTemplate {
    public final User register(String name, String email, String login, String password) {
        validate(name, email, login, password);
        User user = createUser(name, email, login, password);
        assignRole(user);
        notifyRegistration(user);
        return user;
    }

    protected void validate(String name, String email, String login, String password) {
        if (name == null || name.isBlank())     throw new IllegalArgumentException("Name is required");
        if (email == null || email.isBlank())   throw new IllegalArgumentException("Email is required");
        if (login == null || login.isBlank())   throw new IllegalArgumentException("Login is required");
        if (password == null || password.isBlank()) throw new IllegalArgumentException("Password is required");
    }

    protected abstract User createUser(String name, String email, String login, String password);
    protected abstract void assignRole(User user);

    protected void notifyRegistration(User user) {
        System.out.println("Welcome, " + user.getName() + "! Your account has been created.");
    }
}
// Koniec, Tydzień 6, Wzorzec Template 2