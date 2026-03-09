package bp.biblioteka.entity.user;

import java.util.UUID;

public abstract class User {
    private UUID id;
    private String name;
    private String email;
    private String login;
    private String password;

    public User(String name, String email, String login, String password) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public abstract String logIn();
    public abstract String logOut();
}
