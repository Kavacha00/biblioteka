package bp.biblioteka.flyweight.store;

import bp.biblioteka.adapter.store.Loan;
import bp.biblioteka.entity.item.Book;


//Tydzień 4, Wzorzec 1
//Flyweight łączący wypożyczenie z metadanymi książki
//Oszczędza pamięć dzięki współdzieleniu danych książki
public class LoanWithBookFlyweight {

    private final Loan loan;
    private final BookMetaFlyweight metadata;

    public LoanWithBookFlyweight(Loan loan) {
        this.loan = loan;

        Book book = loan.getBook();

        this.metadata = BookMetaFlyweightFactory.getMetadata(
                book.getAuthor(),
                book.getTitle(),
                book.getFormat().format()
        );
    }

    public String getDescription() {
        return loan.getUser().getName() +
                " borrowed " + metadata.getInfo() +
                " from " + loan.getStartDate() + " to " + loan.getEndDate();
    }

    public Loan getLoan() {
        return loan;
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight 1
