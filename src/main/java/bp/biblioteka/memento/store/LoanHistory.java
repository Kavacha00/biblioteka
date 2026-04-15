package bp.biblioteka.memento.store;

import java.util.Stack;

//Tydzień 5, Wzorzec Memento 1
//Caretaker — przechowuje historię mement i pozwala przywracać poprzednie stany wypożyczeń
public class LoanHistory {

    private Stack<LoanMemento> history = new Stack<>();

    public void save(LoanOriginator originator) {
        history.push(originator.save());
    }

    public void undo(LoanOriginator originator) {
        if (!history.isEmpty()) {
            originator.restore(history.pop());
        }
    }
}
// Koniec, Tydzień 5, Wzorzec Memento 1