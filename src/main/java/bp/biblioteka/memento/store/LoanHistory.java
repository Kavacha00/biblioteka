package bp.biblioteka.memento.store;

import java.util.Stack;

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
