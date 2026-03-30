package bp.biblioteka.command.store;

import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.user.User;
import bp.biblioteka.facade.store.StoreFacade;

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