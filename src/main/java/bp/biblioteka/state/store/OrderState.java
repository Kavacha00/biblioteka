// Tydzień 6, Wzorzec State 1
// Wzorzec State zarządzający cyklem życia zamówienia w systemie.
// Umożliwia zmianę zachowania obiektu Order w zależności od jego obecnego stanu.
package bp.biblioteka.state.store;

import bp.biblioteka.entity.store.Order;

public interface OrderState {
    void next(Order order);
    String getStatus();
}
// Koniec, Tydzień 6, Wzorzec State 1