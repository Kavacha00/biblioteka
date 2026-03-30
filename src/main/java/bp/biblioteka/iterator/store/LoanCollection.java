package bp.biblioteka.iterator.store;

import bp.biblioteka.adapter.store.Loan;

import java.util.ArrayList;
import java.util.List;

public class LoanCollection {
    private List<Loan> loans = new ArrayList<>();

    public void add(Loan loan) {
        loans.add(loan);
    }

    public LoanIterator iterator() {
        return new LoanIteratorImpl(loans);
    }

    private static class LoanIteratorImpl implements LoanIterator {
        private List<Loan> loans;
        private int index = 0;

        public LoanIteratorImpl(List<Loan> loans) {
            this.loans = loans;
        }

        @Override
        public boolean hasNext() {
            return index < loans.size();
        }

        @Override
        public Loan next() {
            return loans.get(index++);
        }
    }
}
