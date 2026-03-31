package bp.biblioteka.command.store;

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

class StoreCommandTest {

    private StoreFacade createFacade() {
        CsvReportGenerator generator = new CsvReportGenerator();
        CsvReportAdapter adapter = new CsvReportAdapter(generator);
        return new StoreFacade(adapter);
    }

    @Test
    void shouldExecuteLoanBookCommand() {
        StoreFacade facade = createFacade();
        Employee user = new Employee("Jan", "jan@mail", "login", "pass");
        Book book = new Book("AuthorX", "TitleX", new DigitalFormat());

        LoanBookCommand command = new LoanBookCommand(facade, user, book);

        command.execute();

        assertEquals(1, facade.getLoans().size());

        Loan loan = facade.getLoans().get(0);
        assertEquals(user, loan.getUser());
        assertEquals(book, loan.getBook());
        assertEquals(LocalDate.now(), loan.getStartDate());
        assertEquals(LocalDate.now().plusDays(14), loan.getEndDate());
    }

    @Test
    void shouldExecuteReturnBookCommand() {
        StoreFacade facade = createFacade();
        Employee user = new Employee("Jan", "jan@mail", "login", "pass");
        Book book = new Book("AuthorX", "TitleX", new DigitalFormat());

        Loan loan = facade.loanBook(user, book);
        assertEquals(1, facade.getLoans().size());

        ReturnBookCommand command = new ReturnBookCommand(facade, loan);
        command.execute();

        assertEquals(0, facade.getLoans().size());
    }

    @Test
    void invokerShouldRunCommand() {
        StoreFacade facade = createFacade();
        Employee user = new Employee("Anna", "anna@mail", "login", "pw");
        Book book = new Book("AuthorY", "TitleY", new DigitalFormat());

        LoanBookCommand command = new LoanBookCommand(facade, user, book);
        StoreCommandInvoker invoker = new StoreCommandInvoker();

        invoker.run(command);

        assertEquals(1, facade.getLoans().size());
        assertEquals(user, facade.getLoans().get(0).getUser());
        assertEquals(book, facade.getLoans().get(0).getBook());
    }
}