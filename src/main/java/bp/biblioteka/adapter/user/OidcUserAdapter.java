package bp.biblioteka.adapter.user;

import bp.biblioteka.entity.user.OidcUser;
import bp.biblioteka.entity.user.User;

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
}
//Koniec, Tydzień 3, Wzorzec Adapter 2