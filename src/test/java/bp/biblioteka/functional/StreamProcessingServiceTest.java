package bp.biblioteka.functional;

import bp.biblioteka.bridge.item.DigitalFormat;
import bp.biblioteka.bridge.item.ItemFormat;
import bp.biblioteka.bridge.item.PhysicalFormat;
import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.item.CD;
import bp.biblioteka.entity.item.Item;
import bp.biblioteka.entity.store.Order;
import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.Employee;
import bp.biblioteka.entity.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StreamProcessingServiceTest {

    private StreamProcessingService service;

    private List<Item> items;
    private List<User> users;
    private List<Order> orders;

    @BeforeEach
    void setUp() {
        service = new StreamProcessingService();

    items =
        List.of(
            new Book("Frank Herbert", "Diuna", new PhysicalFormat()),
            new Book("J.R.R. Tolkien", "Władca Pierścieni", new PhysicalFormat()),
            new Book("Isaac Asimov", "Fundacja", new DigitalFormat()),
            new CD("Miles Davis", "Kind of Blue", new DigitalFormat()),
            new CD("The Beatles", "Abbey Road", new PhysicalFormat()));

        var anna  = new Customer("Anna Kowalska",    "anna@example.com",  "ania123", "pass");
        var piotr = new Customer("Piotr Wiśniewski", "piotr@example.com", "piotr1",  "pass");
        var jan   = new Employee("Jan Nowak",        "jan@example.com",   "jnowak",  "pass");
        anna.logIn();
        jan.logIn();
        users = List.of(anna, piotr, jan);

        var o1 = new Order();
        var o2 = new Order();
        var o3 = new Order();
        o1.nextState();
        o2.nextState();
        o2.nextState();
        orders = List.of(o1, o2, o3);
    }

    @Test
    void shouldReturnAllItemTitles() {
        var result = service.getSortedTitlesUpperCase(items);

        assertEquals(items.size(), result.size());
    }

    @Test
    void shouldReturnTitlesSortedAlphabetically() {
        var result = service.getSortedTitlesUpperCase(items);

        for (int i = 0; i < result.size() - 1; i++) {
            assertTrue(result.get(i).compareTo(result.get(i + 1)) <= 0);
        }
    }

    @Test
    void shouldReturnTitlesInUpperCase() {
        var result = service.getSortedTitlesUpperCase(items);

        result.forEach(title -> assertEquals(title.toUpperCase(), title));
    }

    @Test
    void shouldReturnEmptyListForEmptyItemCollection() {
        var result = service.getSortedTitlesUpperCase(List.of());

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnOnlyLoggedInUserEmails() {
        var result = service.getLoggedInEmails(users);

        assertEquals(2, result.size());
    }

    @Test
    void shouldContainEmailsOfLoggedInUsers() {
        var result = service.getLoggedInEmails(users);

        assertTrue(result.contains("anna@example.com"));
        assertTrue(result.contains("jan@example.com"));
    }

    @Test
    void shouldNotContainEmailsOfLoggedOutUsers() {
        var result = service.getLoggedInEmails(users);

        assertFalse(result.contains("piotr@example.com"));
    }

    @Test
    void shouldReturnEmptyListWhenNoUsersAreLoggedIn() {
        var loggedOutUsers = List.<User>of(
                new Customer("A", "a@a.com", "a", "pass"),
                new Employee("B", "b@b.com", "b", "pass")
        );

        var result = service.getLoggedInEmails(loggedOutUsers);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldCountOnlyActiveOrders() {
        var result = service.countActiveOrders(orders);

        assertEquals(2, result);
    }

    @Test
    void shouldReturnZeroActiveOrdersWhenAllAreNew() {
        var newOrders = List.of(new Order(), new Order());

        var result = service.countActiveOrders(newOrders);

        assertEquals(0, result);
    }

    @Test
    void shouldCountAllOrdersAsActiveWhenNoneAreNew() {
        var o1 = new Order(); o1.nextState();
        var o2 = new Order(); o2.nextState();
        var activeOrders = List.of(o1, o2);

        var result = service.countActiveOrders(activeOrders);

        assertEquals(2, result);
    }

    @Test
    void shouldReturnZeroForEmptyOrderCollection() {
        var result = service.countActiveOrders(List.of());

        assertEquals(0, result);
    }
}
