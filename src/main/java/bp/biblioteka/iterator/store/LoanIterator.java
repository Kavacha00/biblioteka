package bp.biblioteka.iterator.store;

import bp.biblioteka.adapter.store.Loan;

public interface LoanIterator {
    boolean hasNext();
    Loan next();
}
