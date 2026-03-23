package bp.biblioteka.decorator.user;

import bp.biblioteka.entity.user.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FirstTimeLoginDecoratorTest {

    @Test
    void shouldCreateFirstTimeLoginDecorator() {
        var user = new Customer("John", "john@mail.com", "john", "pass");

        var decorator = new FirstTimeLoginDecorator(user);

        assertInstanceOf(FirstTimeLoginDecorator.class, decorator);
    }

    @Test
    void shouldLogInUserAndAppendFirstTimeMessage() {
        var user = new Customer("John", "john@mail.com", "john", "pass");

        var decorator = new FirstTimeLoginDecorator(user);

        var result = decorator.logIn();

        assertTrue(user.isLoggedIn());
        assertEquals("Customer logged in for the first time", result);
    }

    @Test
    void shouldPreserveOriginalLoginBehavior() {
        var user = new Customer("John", "john@mail.com", "john", "pass");

        var decorator = new FirstTimeLoginDecorator(user);

        var result = decorator.logIn();

        assertTrue(result.startsWith("Customer logged in"));
    }

    @Test
    void shouldDelegateLogOutWithoutModification() {
        var user = new Customer("John", "john@mail.com", "john", "pass");
        user.setLoggedIn(true);

        var decorator = new FirstTimeLoginDecorator(user);

        var result = decorator.logOut();

        assertEquals("Customer logged out", result);
        assertFalse(user.isLoggedIn());
    }

    @Test
    void shouldWorkCorrectlyAcrossMultipleCalls() {
        var user = new Customer("John", "john@mail.com", "john", "pass");

        var decorator = new FirstTimeLoginDecorator(user);

        var first = decorator.logIn();
        var second = decorator.logIn();

        assertEquals("Customer logged in for the first time", first);
        assertEquals("Customer logged in for the first time", second);
        assertTrue(user.isLoggedIn());
    }
}