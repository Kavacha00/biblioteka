package bp.biblioteka.composite.user;

import bp.biblioteka.entity.user.User;

import java.util.List;

//Tydzień 3, Wzorzec Composite 2,
// Wzorzec Composite pozwala traktować pojedyncze obiekty oraz ich grupy w jednolity sposób.
// UserGroup agreguje wiele obiektów User i deleguje do nich operacje.
public class UserGroup extends User {
    private final List<User> users;
    private final StringBuilder builder;

    public UserGroup(List<User> users, StringBuilder builder) {
        this.users = users;
        this.builder = builder;
    }

    @Override
    public String logIn() {
        users.forEach(user -> {
            user.setLoggedIn(true);
            builder.append(user.getId()).append(" logged in\n");
        });
        var msg = builder.toString();
        builder.setLength(0);

        return msg;
    }

    @Override
    public String logOut() {
        users.forEach(user -> {
            user.setLoggedIn(false);
            builder.append(user.getId()).append(" logged out\n");
        });
        var msg = builder.toString();
        builder.setLength(0);

        return msg;
    }
}
//Koniec, Tydzień 3, Wzorzec Composite 2