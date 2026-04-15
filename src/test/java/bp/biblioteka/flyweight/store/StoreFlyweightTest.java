package bp.biblioteka.flyweight.store;

import bp.biblioteka.adapter.store.Loan;
import bp.biblioteka.bridge.item.DigitalFormat;
import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.user.Employee;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StoreFlyweightTest {

    @Test
    void shouldReturnSameFlyweightForSameBookMetadata() {
        BookMetaFlyweight f1 = BookMetaFlyweightFactory.getMetadata(
                "AuthorX", "TitleX", "PDF"
        );

        BookMetaFlyweight f2 = BookMetaFlyweightFactory.getMetadata(
                "AuthorX", "TitleX", "PDF"
        );

        assertSame(f1, f2);
    }

    @Test
    void shouldReturnDifferentFlyweightsForDifferentBooks() {
        BookMetaFlyweight f1 = BookMetaFlyweightFactory.getMetadata("A1", "T1", "PDF");
        BookMetaFlyweight f2 = BookMetaFlyweightFactory.getMetadata("A2", "T2", "PDF");

        assertNotSame(f1, f2);
    }

    @Test
    void shouldWrapLoanWithBookFlyweight() {
        Employee user = new Employee("Jan", "jan@mail", "login", "pw");
        Book book = new Book("A1", "T1", new DigitalFormat());
        Loan loan = new Loan();

        loan.setBook(book);
        loan.setUser(user);
        loan.setStartDate(LocalDate.of(2024, 1, 1));
        loan.setEndDate(LocalDate.of(2024, 1, 10));

        LoanWithBookFlyweight lw = new LoanWithBookFlyweight(loan);

        String desc = lw.getDescription();

        assertTrue(desc.contains("A1"));
        assertTrue(desc.contains("T1"));
        assertTrue(desc.contains("Format elektroniczny"));
        assertTrue(desc.contains("2024-01-01"));
        assertTrue(desc.contains("2024-01-10"));
    }
}
