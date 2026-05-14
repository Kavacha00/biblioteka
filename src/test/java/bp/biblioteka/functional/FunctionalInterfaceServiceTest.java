package bp.biblioteka.functional;

import bp.biblioteka.bridge.item.DigitalFormat;
import bp.biblioteka.bridge.item.PhysicalFormat;
import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.item.CD;
import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionalInterfaceServiceTest {

    private FunctionalInterfaceService service;

    private Book book;
    private CD cd;
    private Customer customer;
    private Employee employee;

    @BeforeEach
    void setUp() {
        service  = new FunctionalInterfaceService();
        book = new Book("Frank Herbert", "Diuna", new PhysicalFormat());
        cd = new CD("Miles Davis", "Kind of Blue", new DigitalFormat());
        customer = new Customer("Anna Kowalska", "anna@example.com", "ania123", "pass");
        employee = new Employee("Jan Nowak", "jan@example.com", "jnowak", "pass");
    }

    // ── ItemPricer ────────────────────────────────────────────────────────────

    @Test
    void shouldCalculateStandardDiscountPrice() {
        var result = service.calculateStandardDiscount(100.0, 0.20);

        assertEquals(80.0, result, 0.001);
    }

    @Test
    void shouldCalculateHolidayDiscountPrice() {
        var result = service.calculateHolidayDiscount(100.0, 0.20);

        // 100 * (1 - 0.20) - 5.0 = 75.0
        assertEquals(75.0, result, 0.001);
    }

    @Test
    void shouldReturnLowerPriceForHolidayDiscountThanStandard() {
        double standard = service.calculateStandardDiscount(100.0, 0.10);
        double holiday  = service.calculateHolidayDiscount(100.0, 0.10);

        assertTrue(holiday < standard);
    }

    @Test
    void shouldReturnFullPriceWhenDiscountRateIsZero() {
        var result = service.calculateStandardDiscount(59.99, 0.0);

        assertEquals(59.99, result, 0.001);
    }

    // ── ItemDescriber ─────────────────────────────────────────────────────────

    @Test
    void shouldReturnCatalogDescriptionWithPrefix() {
        var result = service.describeCatalog(book);

        assertTrue(result.startsWith("[KATALOG] "));
    }

    @Test
    void shouldReturnCatalogDescriptionContainingItemDescribe() {
        var result = service.describeCatalog(book);

        assertTrue(result.contains(book.describe()));
    }

    @Test
    void shouldReturnShortDescriptionContainingTitleAndAuthor() {
        var result = service.describeShort(book);

        assertTrue(result.contains(book.getTitle()));
        assertTrue(result.contains(book.getAuthor()));
    }

    @Test
    void shouldReturnShortDescriptionForCD() {
        var result = service.describeShort(cd);

        assertTrue(result.contains(cd.getTitle()));
        assertTrue(result.contains(cd.getAuthor()));
    }

    // ── UserNotifier ──────────────────────────────────────────────────────────

    @Test
    void shouldReturnNonNullResultFromEmailNotifier() {
        var result = service.notifyByEmail(customer, "Zamówienie gotowe.");

        assertNotNull(result);
    }

    @Test
    void shouldReturnNonNullResultFromLogNotifier() {
        var result = service.notifyByLog(employee, "Nowe zadanie.");

        assertNotNull(result);
    }

    @Test
    void shouldReturnLogEntryContainingUserName() {
        var result = service.notifyByLog(customer, "Test.");

        assertTrue(result.contains(customer.getName()));
    }

    @Test
    void shouldReturnLogEntryContainingMessage() {
        String message = "Twoje zamówienie jest gotowe.";
        var result = service.notifyByLog(employee, message);

        assertTrue(result.contains(message));
    }

    @Test
    void shouldReturnLogEntryWithLogPrefix() {
        var result = service.notifyByLog(customer, "Test.");

        assertTrue(result.startsWith("[LOG]"));
    }
}

