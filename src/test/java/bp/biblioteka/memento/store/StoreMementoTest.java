package bp.biblioteka.memento.store;

import bp.biblioteka.adapter.store.Loan;
import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.user.Employee;
import bp.biblioteka.bridge.item.DigitalFormat;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StoreMementoTest {

    private Loan createLoan() {
        Loan loan = new Loan();

        loan.setUser(new Employee("Jan", "mail", "login", "pass"));
        loan.setBook(new Book("A", "B", new DigitalFormat()));
        loan.setStartDate(LocalDate.of(2024, 1, 1));
        loan.setEndDate(LocalDate.of(2024, 1, 15));

        return loan;
    }

    @Test
    void shouldSaveAndRestorePreviousState() {
        Loan loan = createLoan();
        LoanOriginator originator = new LoanOriginator(loan);
        LoanHistory history = new LoanHistory();

        history.save(originator);

        loan.setStartDate(LocalDate.of(2024, 2, 1));
        loan.setEndDate(LocalDate.of(2024, 2, 20));

        history.undo(originator);

        assertEquals(LocalDate.of(2024, 1, 1), loan.getStartDate());
        assertEquals(LocalDate.of(2024, 1, 15), loan.getEndDate());
    }

    @Test
    void shouldRestoreMultiplePreviousStates() {
        Loan loan = createLoan();
        LoanOriginator originator = new LoanOriginator(loan);
        LoanHistory history = new LoanHistory();

        history.save(originator);

        loan.setStartDate(LocalDate.of(2024, 2, 1));
        loan.setEndDate(LocalDate.of(2024, 2, 20));
        history.save(originator);

        loan.setStartDate(LocalDate.of(2024, 3, 1));
        loan.setEndDate(LocalDate.of(2024, 3, 15));

        history.undo(originator);
        assertEquals(LocalDate.of(2024, 2, 1), loan.getStartDate());
        assertEquals(LocalDate.of(2024, 2, 20), loan.getEndDate());

        history.undo(originator);
        assertEquals(LocalDate.of(2024, 1, 1), loan.getStartDate());
        assertEquals(LocalDate.of(2024, 1, 15), loan.getEndDate());
    }

    @Test
    void undoShouldDoNothingWhenHistoryIsEmpty() {
        Loan loan = createLoan();
        LoanOriginator originator = new LoanOriginator(loan);
        LoanHistory history = new LoanHistory();

        originator.restore(new LoanMemento(
                LocalDate.of(2024, 5, 1),
                LocalDate.of(2024, 5, 10)
        ));

        history.undo(originator);

        assertEquals(LocalDate.of(2024, 5, 1), loan.getStartDate());
        assertEquals(LocalDate.of(2024, 5, 10), loan.getEndDate());
    }
}