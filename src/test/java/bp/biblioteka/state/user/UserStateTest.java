package bp.biblioteka.state.user;

import bp.biblioteka.entity.user.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserStateTest {

    @Test
    void shouldHaveActiveStateByDefault() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        assertEquals("ACTIVE", employee.getStateName());
    }

    @Test
    void shouldTransitionToBannedState() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        employee.ban();

        assertEquals("BANNED", employee.getStateName());
    }

    @Test
    void shouldTransitionToSuspendedState() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        employee.suspend();

        assertEquals("SUSPENDED", employee.getStateName());
    }

    @Test
    void shouldTransitionFromBannedToActive() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        employee.ban();
        employee.activate();

        assertEquals("ACTIVE", employee.getStateName());
    }

    @Test
    void shouldTransitionFromSuspendedToActive() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        employee.suspend();
        employee.activate();

        assertEquals("ACTIVE", employee.getStateName());
    }

    @Test
    void shouldReturnCorrectMessageWhenAlreadyActive() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        String message = employee.activate();

        assertEquals("User is already active", message);
    }

    @Test
    void shouldReturnCorrectMessageWhenAlreadyBanned() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        employee.ban();
        String message = employee.ban();

        assertEquals("User is already banned", message);
    }

    @Test
    void shouldReturnCorrectMessageWhenAlreadySuspended() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        employee.suspend();
        String message = employee.suspend();

        assertEquals("User is already suspended", message);
    }

    @Test
    void shouldReturnCorrectMessageWhenBanningBannedUser() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        employee.ban();
        String message = employee.suspend();

        assertEquals("User is banned, cannot suspend", message);
    }

    @Test
    void shouldNotifyObserverOnBan() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        List<String> receivedEvents = new ArrayList<>();
        employee.addUserObserver((login, event) -> receivedEvents.add(event));

        employee.ban();

        assertTrue(receivedEvents.contains("USER_BANNED"));
    }

    @Test
    void shouldNotifyObserverOnSuspend() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        List<String> receivedEvents = new ArrayList<>();
        employee.addUserObserver((login, event) -> receivedEvents.add(event));

        employee.suspend();

        assertTrue(receivedEvents.contains("USER_SUSPENDED"));
    }

    @Test
    void shouldNotifyObserverOnActivate() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        List<String> receivedEvents = new ArrayList<>();
        employee.addUserObserver((login, event) -> receivedEvents.add(event));

        employee.ban();
        receivedEvents.clear();
        employee.activate();

        assertTrue(receivedEvents.contains("USER_ACTIVE"));
    }
}