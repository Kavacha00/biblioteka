package bp.biblioteka.command.store;

import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.user.User;
import bp.biblioteka.facade.store.StoreFacade;

//Tydzień 5, Wzorzec Command 1
//Polecenie wypożyczenia książki
//Encapsuluje: kto wypożycza (User), co wypożycza (Book)
//Deleguje wykonanie operacji do StoreFacade
public class LoanBookCommand implements StoreCommand {

    private final StoreFacade storeFacade;
    private final User user;
    private final Book book;

    public LoanBookCommand(StoreFacade storeFacade, User user, Book book) {
        this.storeFacade = storeFacade;
        this.user = user;
        this.book = book;
    }

    @Override
    public void execute() {
        storeFacade.loanBook(user, book);
    }
}
// Koniec, Tydzień 5, Wzorzec Command 1