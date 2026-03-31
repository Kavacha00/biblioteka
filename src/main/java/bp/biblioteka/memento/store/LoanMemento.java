package bp.biblioteka.memento.store;

import java.time.LocalDate;

public class LoanMemento {
    private final LocalDate startDate;
    private final LocalDate endDate;

    public LoanMemento(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
}
