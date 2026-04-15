package bp.biblioteka.iterator.store;

import bp.biblioteka.adapter.store.Loan;
import java.util.List;

//Tydzień 5, Wzorzec Iterator 1
//Iterator filtrujący — przechodzi tylko po aktywnych wypożyczeniach (endDate == null)
public class ActiveLoanIterator implements LoanIterator {
    private final List<Loan> loans;
    private int index = 0;

    public ActiveLoanIterator(List<Loan> loans) {
        this.loans = loans;
        moveToNextActive();
    }

    private void moveToNextActive() {
        while (index < loans.size() && loans.get(index).getEndDate() != null) {
            index++;
        }
    }

    @Override
    public boolean hasNext() {
        return index < loans.size();
    }

    @Override
    public Loan next() {
        Loan loan = loans.get(index++);
        moveToNextActive();
        return loan;
    }
}
// Koniec, Tydzień 5, Wzorzec Iterator 1