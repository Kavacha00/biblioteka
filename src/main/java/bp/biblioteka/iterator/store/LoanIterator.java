package bp.biblioteka.iterator.store;

import bp.biblioteka.adapter.store.Loan;

//Tydzień 5, Wzorzec Iterator 1
//Interfejs iteratora dla kolekcji wypożyczeń
public interface LoanIterator {
    boolean hasNext();
    Loan next();
}
// Koniec, Tydzień 5, Wzorzec Iterator 1