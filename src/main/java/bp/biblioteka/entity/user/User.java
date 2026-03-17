package bp.biblioteka.entity.user;

import bp.biblioteka.entity.store.Store;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public abstract class User implements Cloneable {
    private UUID id;
    private boolean loggedIn = false;
    private String name;
    private String email;
    private String login;
    private String password;

    public User() {}

    public User(String name, String email, String login, String password) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    protected User(UUID id, String name, String email, String login, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public abstract String logIn();
    public abstract String logOut();

    @Override
    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
