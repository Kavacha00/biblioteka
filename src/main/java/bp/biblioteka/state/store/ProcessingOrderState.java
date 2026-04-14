// Tydzień 6, Wzorzec State 1
// Implementacja stanu przetwarzania zamówienia.
// Przejście z tego stanu kieruje zamówienie do statusu zakończonego.
package bp.biblioteka.state.store;

import bp.biblioteka.entity.store.Order;

public class ProcessingOrderState implements OrderState {

    @Override
    public void next(Order order) {
        order.setState(new CompletedOrderState());
    }

    @Override
    public String getStatus() {
        return "Zamówienie w trakcie przetwarzania";
    }
}
// Koniec, Tydzień 6, Wzorzec State 1