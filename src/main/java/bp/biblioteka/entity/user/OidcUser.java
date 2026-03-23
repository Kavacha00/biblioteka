package bp.biblioteka.entity.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OidcUser {
    private String openIdToken;

    private String email;
    private boolean emailVerified;

    private String name;
    private String familyName;
    private String givenName;
    private String middleName;
    private String nickname;
    private String pictureUrl;
    private Date updated_at;

    private boolean loggedIn = false;

    public String authenticate(){
        this.setLoggedIn(true);
        return "OidcUser logged in";
    }

    public String logout(){
        this.setLoggedIn(false);
        return "OidcUser logged out";
    }
}
