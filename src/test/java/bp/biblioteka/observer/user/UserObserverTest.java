package bp.biblioteka.observer.user;

import bp.biblioteka.entity.user.Employee;
import bp.biblioteka.entity.user.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserObserverTest {

    @Test
    void shouldAddObserverToEmployee() throws Exception {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");
        UserObserver observer = (login, event) -> {};

        employee.addUserObserver(observer);

        Field field = User.class.getDeclaredField("observers");
        field.setAccessible(true);
        List<UserObserver> observers = (List<UserObserver>) field.get(employee);

        assertEquals(1, observers.size());
    }

    @Test
    void shouldRemoveObserverFromEmployee() throws Exception {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");
        UserObserver observer = (login, event) -> {};

        employee.addUserObserver(observer);
        employee.removeUserObserver(observer);

        Field field = User.class.getDeclaredField("observers");
        field.setAccessible(true);
        List<UserObserver> observers = (List<UserObserver>) field.get(employee);

        assertEquals(0, observers.size());
    }

    @Test
    void shouldNotifyObserverOnLogin() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        List<String> receivedEvents = new ArrayList<>();
        employee.addUserObserver((login, event) -> receivedEvents.add(event));

        employee.logIn();

        assertEquals(1, receivedEvents.size());
        assertEquals("USER_LOGGED_IN", receivedEvents.get(0));
    }

    @Test
    void shouldNotifyObserverOnLogout() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        List<String> receivedEvents = new ArrayList<>();
        employee.addUserObserver((login, event) -> receivedEvents.add(event));

        employee.logOut();

        assertEquals(1, receivedEvents.size());
        assertEquals("USER_LOGGED_OUT", receivedEvents.get(0));
    }

    @Test
    void shouldNotifyObserverWithCorrectLogin() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        List<String> receivedLogins = new ArrayList<>();
        employee.addUserObserver((login, event) -> receivedLogins.add(login));

        employee.logIn();

        assertEquals("John's Login", receivedLogins.get(0));
    }

    @Test
    void shouldNotifyAllObservers() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        List<String> firstObserverEvents = new ArrayList<>();
        List<String> secondObserverEvents = new ArrayList<>();

        employee.addUserObserver((login, event) -> firstObserverEvents.add(event));
        employee.addUserObserver((login, event) -> secondObserverEvents.add(event));

        employee.logIn();

        assertEquals(1, firstObserverEvents.size());
        assertEquals(1, secondObserverEvents.size());
    }

    @Test
    void shouldNotNotifyRemovedObserver() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        List<String> receivedEvents = new ArrayList<>();
        UserObserver observer = (login, event) -> receivedEvents.add(event);

        employee.addUserObserver(observer);
        employee.removeUserObserver(observer);

        employee.logIn();

        assertEquals(0, receivedEvents.size());
    }
}