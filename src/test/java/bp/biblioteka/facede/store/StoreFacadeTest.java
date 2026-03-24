package bp.biblioteka.facede.store;

import bp.biblioteka.adapter.store.CsvReportAdapter;
import bp.biblioteka.adapter.store.CsvReportGenerator;
import bp.biblioteka.adapter.store.Loan;
import bp.biblioteka.bridge.item.DigitalFormat;
import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.user.Employee;
import bp.biblioteka.facade.store.StoreFacade;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StoreFacadeTest {

    @Test
    void shouldCreateLoanThroughFacade() {
        CsvReportGenerator generator = new CsvReportGenerator();
        CsvReportAdapter adapter = new CsvReportAdapter(generator);

        StoreFacade facade = new StoreFacade(adapter);

        Employee user = new Employee("Jan", "jan@mail", "login", "pass");
        Book book = new Book("AuthorX", "TitleX", new DigitalFormat());

        Loan loan = facade.loanBook(user, book);

        assertEquals(user, loan.getUser());
        assertEquals(book, loan.getBook());
        assertEquals(LocalDate.now(), loan.getStartDate());
        assertEquals(LocalDate.now().plusDays(14), loan.getEndDate());
    }

    @Test
    void shouldRemoveLoanWhenReturned() {
        CsvReportGenerator generator = new CsvReportGenerator();
        CsvReportAdapter adapter = new CsvReportAdapter(generator);

        StoreFacade facade = new StoreFacade(adapter);

        Employee user = new Employee("Jan", "j@mail", "login", "pw");
        Book book = new Book("A", "B", new DigitalFormat());

        Loan loan = facade.loanBook(user, book);

        assertEquals(1, facade.getLoans().size());

        facade.returnBook(loan);

        assertEquals(0, facade.getLoans().size());
    }
}
