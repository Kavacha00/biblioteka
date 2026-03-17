package bp.biblioteka.adapter.user;

import bp.biblioteka.entity.user.OidcUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OidcUserAdapterTest {

    @Test
    void shouldCreateOidcUserAdapter() {
        OidcUser oidcUser = new OidcUser();

        var adapter = new OidcUserAdapter(oidcUser);

        assertInstanceOf(OidcUserAdapter.class, adapter);
    }

    @Test
    void shouldLogInUsingOidcUser() {
        OidcUser oidcUser = new OidcUser();
        var adapter = new OidcUserAdapter(oidcUser);

        var result = adapter.logIn();

        assertEquals("OidcUser logged in", result);
        assertTrue(oidcUser.isLoggedIn());
    }

    @Test
    void shouldLogOutUsingOidcUser() {
        OidcUser oidcUser = new OidcUser();
        oidcUser.setLoggedIn(true); // simulate logged-in state

        var adapter = new OidcUserAdapter(oidcUser);

        var result = adapter.logOut();

        assertEquals("OidcUser logged out", result);
        assertFalse(oidcUser.isLoggedIn());
    }

    @Test
    void shouldSwitchStateBetweenLogInAndLogOut() {
        OidcUser oidcUser = new OidcUser();
        var adapter = new OidcUserAdapter(oidcUser);

        adapter.logIn();
        assertTrue(oidcUser.isLoggedIn());

        adapter.logOut();
        assertFalse(oidcUser.isLoggedIn());
    }

    @Test
    void shouldDelegateCallsToSameOidcUserInstance() {
        OidcUser oidcUser = new OidcUser();
        var adapter = new OidcUserAdapter(oidcUser);

        adapter.logIn();
        assertTrue(oidcUser.isLoggedIn());

        adapter.logOut();
        assertFalse(oidcUser.isLoggedIn());
    }
}