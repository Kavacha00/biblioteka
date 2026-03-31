package bp.biblioteka.mediator.store;

import bp.biblioteka.adapter.store.Loan;
import bp.biblioteka.adapter.store.ReportService;
import bp.biblioteka.bridge.item.DigitalFormat;
import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.user.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StoreMediatorTest {

    private ByteArrayOutputStream outputCaptor;

    @BeforeEach
    void setupStreams() {
        outputCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCaptor));
    }

    private Loan createLoan() {
        Employee user = new Employee("Jan", "mail", "login", "pass");
        Book book = new Book("Author", "Title", new DigitalFormat());

        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setStartDate(LocalDate.now());
        return loan;
    }

    @Test
    void mediatorShouldHandleBookLoanedEvent() {
        NotificationService notification = new NotificationService();
        InventoryService inventory = new InventoryService();
        ReportService report = loans -> {}; // ← pusta implementacja

        StoreEventMediator mediator =
                new StoreEventMediator(notification, inventory, report);

        Loan loan = createLoan();

        mediator.notify(this, "BOOK_LOANED", loan);

        String output = outputCaptor.toString();

        assertTrue(output.contains("Loan confirmation sent"));
        assertTrue(output.contains("marked as unavailable"));
        assertTrue(output.contains("Title"));
    }

    @Test
    void mediatorShouldHandleBookReturnedEvent() {
        NotificationService notification = new NotificationService();
        InventoryService inventory = new InventoryService();
        ReportService report = loans -> {}; // ← pusta implementacja

        StoreEventMediator mediator =
                new StoreEventMediator(notification, inventory, report);

        Loan loan = createLoan();

        mediator.notify(this, "BOOK_RETURNED", loan);

        String output = outputCaptor.toString();

        assertTrue(output.contains("Return confirmation sent"));
        assertTrue(output.contains("is available again"));
        assertTrue(output.contains("Title"));
    }

    @Test
    void mediatorShouldHandleLoanExtendedEvent() {
        NotificationService notification = new NotificationService();
        InventoryService inventory = new InventoryService();
        ReportService report = loans -> {}; // ← pusta implementacja

        StoreEventMediator mediator =
                new StoreEventMediator(notification, inventory, report);

        Loan loan = createLoan();

        mediator.notify(this, "LOAN_EXTENDED", loan);

        String output = outputCaptor.toString();

        assertTrue(output.contains("Loan extended"));
    }
}