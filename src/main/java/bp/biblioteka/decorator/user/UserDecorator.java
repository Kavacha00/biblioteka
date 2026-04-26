package bp.biblioteka.decorator.user;

import bp.biblioteka.entity.user.User;
import bp.biblioteka.visitor.user.UserVisitor;


//Tydzień 3, Wzorzec Decorator 2,
// Wzorzec Decorator pozwala dynamicznie rozszerzać zachowanie obiektu
// poprzez opakowanie go w obiekt dekoratora bez zmiany jego klasy bazowej.
public class UserDecorator extends User {
    private final User user;

    public UserDecorator(User user) {
        this.user = user;
    }

    @Override
    public String logIn() {
        return user.logIn();
    }

    @Override
    public String logOut() {
        return user.logOut();
    }

    @Override
    public String accept(UserVisitor visitor) {
        return user.accept(visitor);
    }
}
//Koniec, Tydzień 3, Wzorzec Decorator 2
