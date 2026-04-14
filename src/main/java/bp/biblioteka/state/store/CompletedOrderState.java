// Tydzień 6, Wzorzec State 1
// Implementacja końcowego stanu zamówienia.
// W tym stanie zamówienie jest zamknięte i nie przechodzi w kolejne stany.
package bp.biblioteka.state.store;

import bp.biblioteka.entity.store.Order;

public class CompletedOrderState implements OrderState {

    @Override
    public void next(Order order) {

    }

    @Override
    public String getStatus() {
        return "Zamówienie zakończone";
    }
}
// Koniec, Tydzień 6, Wzorzec State 1