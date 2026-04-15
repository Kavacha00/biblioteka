package bp.biblioteka.memento.store;

import java.time.LocalDate;

//Tydzień 5, Wzorzec Memento 1
//Memento — przechowuje stan wypożyczenia (datę startu i końca)
//Zachowywany obiekt jest niemutowalny
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
// Koniec, Tydzień 5, Wzorzec Memento 1