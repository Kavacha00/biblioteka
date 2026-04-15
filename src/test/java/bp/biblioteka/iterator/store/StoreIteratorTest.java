package bp.biblioteka.iterator.store;

import bp.biblioteka.adapter.store.Loan;
import bp.biblioteka.bridge.item.DigitalFormat;
import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.user.Employee;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StoreIteratorTest {

    private Loan createLoan(Employee user, Book book, boolean active) {
        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setStartDate(LocalDate.now());
        if (!active) {
            loan.setEndDate(LocalDate.now().minusDays(1));
        }
        return loan;
    }

    @Test
    void activeLoanIteratorShouldReturnOnlyActiveLoans() {
        Employee user = new Employee("Jan", "jan@mail", "login", "pass");
        Book book1 = new Book("A1", "T1", new DigitalFormat());
        Book book2 = new Book("A2", "T2", new DigitalFormat());
        Book book3 = new Book("A3", "T3", new DigitalFormat());

        Loan active1 = createLoan(user, book1, true);
        Loan inactive = createLoan(user, book2, false);
        Loan active2 = createLoan(user, book3, true);

        ActiveLoanIterator iterator = new ActiveLoanIterator(
                Arrays.asList(active1, inactive, active2)
        );

        assertTrue(iterator.hasNext());
        assertEquals(active1, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(active2, iterator.next());

        assertFalse(iterator.hasNext());
    }

    @Test
    void loanCollectionIteratorShouldIterateAllLoans() {
        Employee user = new Employee("Jan", "mail", "login", "pw");
        Book book1 = new Book("A1", "B1", new DigitalFormat());
        Book book2 = new Book("A2", "B2", new DigitalFormat());

        Loan loan1 = createLoan(user, book1, true);
        Loan loan2 = createLoan(user, book2, true);

        LoanCollection collection = new LoanCollection();
        collection.add(loan1);
        collection.add(loan2);

        LoanIterator iterator = collection.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(loan1, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(loan2, iterator.next());

        assertFalse(iterator.hasNext());
    }
}