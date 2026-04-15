package bp.biblioteka.memento.cart;

import java.util.Stack;

//Tydzień 5, Wzorzec Memento 2
//Możliwość przywrócenia koszyka do poprzednich stanów
public class CartHistory {
    private final Stack<CartMemento> history = new Stack<>();

    public void save(CartMemento memento){
        history.push(memento);
    }

    public CartMemento undo() {
        if(!history.isEmpty()){
            return history.pop();
        }
        return null;
    }
}
//Koniec, Tydzień 5, Wzorzec Memento 2