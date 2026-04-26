package bp.biblioteka.adapter.user;

import bp.biblioteka.entity.user.OidcUser;
import bp.biblioteka.entity.user.User;
import bp.biblioteka.visitor.user.UserVisitor;

//Tydzień 3, Wzorzec Adapter 2,
// Adapter umożliwia dostosowanie klasy OidcUser (Zewnętrzny user od auth providera)
// do klasy użytkowników w systemie wewenętrznym

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

    @Override
    public String accept(UserVisitor visitor) {
        return visitor.visit(this);
    }
}
//Koniec, Tydzień 3, Wzorzec Adapter 2