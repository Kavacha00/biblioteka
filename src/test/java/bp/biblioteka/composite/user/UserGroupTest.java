package bp.biblioteka.composite.user;

import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class UserGroupTest {

    @Test
    void shouldCreateUserGroup() {
        List<User> users = List.of(
                new Customer("John", "john@mail.com", "john", "pass"),
                new Customer("Jane", "jane@mail.com", "jane", "pass")
        );

        var group = new UserGroup(users, new StringBuilder());

        assertInstanceOf(UserGroup.class, group);
    }

    @Test
    void shouldLogInAllUsers() {
        var user1 = new Customer("John", "john@mail.com", "john", "pass");
        var user2 = new Customer("Jane", "jane@mail.com", "jane", "pass");

        var group = new UserGroup(List.of(user1, user2), new StringBuilder());

        var result = group.logIn();

        assertTrue(user1.isLoggedIn());
        assertTrue(user2.isLoggedIn());

        assertEquals(
                user1.getId() + " logged in\n" +
                        user2.getId() + " logged in\n",
                result
        );
    }

    @Test
    void shouldLogOutAllUsers() {
        var user1 = new Customer("John", "john@mail.com", "john", "pass");
        var user2 = new Customer("Jane", "jane@mail.com", "jane", "pass");

        user1.setLoggedIn(true);
        user2.setLoggedIn(true);

        var group = new UserGroup(List.of(user1, user2), new StringBuilder());

        var result = group.logOut();

        assertFalse(user1.isLoggedIn());
        assertFalse(user2.isLoggedIn());

        assertEquals(
                user1.getId() + " logged out\n" +
                        user2.getId() + " logged out\n",
                result
        );
    }

    @Test
    void shouldClearBuilderAfterLogIn() {
        var user = new Customer("John", "john@mail.com", "john", "pass");
        var builder = new StringBuilder();

        var group = new UserGroup(List.of(user), builder);

        group.logIn();

        assertEquals(0, builder.length());
    }

    @Test
    void shouldClearBuilderAfterLogOut() {
        var user = new Customer("John", "john@mail.com", "john", "pass");
        var builder = new StringBuilder();

        var group = new UserGroup(List.of(user), builder);

        group.logOut();

        assertEquals(0, builder.length());
    }

    @Test
    void shouldHandleEmptyUserList() {
        var group = new UserGroup(List.of(), new StringBuilder());

        var loginResult = group.logIn();
        var logoutResult = group.logOut();

        assertEquals("", loginResult);
        assertEquals("", logoutResult);
    }

    @Test
    void shouldHandleMultipleCallsCorrectly() {
        var user = new Customer("John", "john@mail.com", "john", "pass");
        var group = new UserGroup(List.of(user), new StringBuilder());

        var first = group.logIn();
        var second = group.logOut();

        assertEquals(user.getId() + " logged in\n", first);
        assertEquals(user.getId() + " logged out\n", second);
    }
}