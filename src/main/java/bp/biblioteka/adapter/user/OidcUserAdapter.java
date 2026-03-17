package bp.biblioteka.adapter.user;

import bp.biblioteka.entity.user.OidcUser;
import bp.biblioteka.entity.user.User;

public class OidcUserAdapter extends User {
    private final OidcUser user;

    public OidcUserAdapter(OidcUser user) {
        this.user = user;
    }

    @Override
    public String logIn() {
        return this.user.authenticate();
    }

    @Override
    public String logOut() {
        return this.user.logout();
    }
}
