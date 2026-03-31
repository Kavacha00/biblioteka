package bp.biblioteka.command.store;

import bp.biblioteka.adapter.store.Loan;
import bp.biblioteka.facade.store.StoreFacade;

//Tydzień 5, Wzorzec Command 1
//Polecenie zwrotu książki
//Przechowuje obiekt Loan i deleguje zwrot do StoreFacade
public class ReturnBookCommand implements StoreCommand {

    private final StoreFacade storeFacade;
    private final Loan loan;

    public ReturnBookCommand(StoreFacade storeFacade, Loan loan) {
        this.storeFacade = storeFacade;
        this.loan = loan;
    }

    @Override
    public void execute() {
        storeFacade.returnBook(loan);
    }
}
// Koniec, Tydzień 5, Wzorzec Command 1