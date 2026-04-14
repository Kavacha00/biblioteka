// Tydzień 6, Wzorzec State 1
// Implementacja początkowego stanu zamówienia.
// Przejście z tego stanu kieruje zamówienie do przetwarzania.
package bp.biblioteka.state.store;

import bp.biblioteka.entity.store.Order;

public class NewOrderState implements OrderState {

    @Override
    public void next(Order order) {
        order.setState(new ProcessingOrderState());
    }

    @Override
    public String getStatus() {
        return "Nowe zamówienie";
    }
}
// Koniec, Tydzień 6, Wzorzec State 1