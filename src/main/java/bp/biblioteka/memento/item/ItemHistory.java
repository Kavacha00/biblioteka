package bp.biblioteka.memento.item;

import java.util.Stack;

public class ItemHistory {
    private Stack<ItemMemento> history = new Stack<>();

    public void backup(ItemMemento itemMemento) {
        history.push(itemMemento);
    }

    public ItemMemento undo() {
        if (history.isEmpty())
            System.out.println("History is empty");
        return history.pop();
    }
}
//Koniec, Tydzień 5, Wzorzec Memento 3
