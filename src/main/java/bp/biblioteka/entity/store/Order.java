// Tydzień 6, Wzorzec State 1
// Klasa Context przechowująca referencję do aktualnego stanu zamówienia.
// Deleguje wywołania metod związanych ze statusem do odpowiedniego obiektu stanu.
package bp.biblioteka.entity.store;

import bp.biblioteka.state.store.NewOrderState;
import bp.biblioteka.state.store.OrderState;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Order {
    private UUID id;
    private OrderState state;

    public Order() {
        this.id = UUID.randomUUID();
        this.state = new NewOrderState();
    }

    public void nextState() {
        state.next(this);
    }

    public String printStatus() {
        return state.getStatus();
    }
}
// Koniec, Tydzień 6, Wzorzec State 1