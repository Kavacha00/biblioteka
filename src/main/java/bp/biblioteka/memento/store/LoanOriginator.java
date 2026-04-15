package bp.biblioteka.memento.store;

import bp.biblioteka.adapter.store.Loan;

//Tydzień 5, Wzorzec Memento 1
//Originator — tworzy memento i potrafi odtworzyć stan wypożyczenia
public class LoanOriginator {

    private Loan loan;

    public LoanOriginator(Loan loan) {
        this.loan = loan;
    }

    public LoanMemento save() {
        return new LoanMemento(loan.getStartDate(), loan.getEndDate());
    }

    public void restore(LoanMemento memento) {
        loan.setStartDate(memento.getStartDate());
        loan.setEndDate(memento.getEndDate());
    }
}
// Koniec, Tydzień 5, Wzorzec Memento 1