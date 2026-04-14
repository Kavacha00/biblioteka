// Tydzień 6, Wzorzec Template 1
// Wzorzec Template Method definiujący szkielet algorytmu przetwarzania zamówienia.
// Podklasy implementują specyficzne kroki, nie zmieniając samej struktury algorytmu.
package bp.biblioteka.template.store;

import bp.biblioteka.entity.store.Order;

public abstract class OrderProcessor {

    public final String processOrder(Order order) {
        String result = verifyAvailability(order) + "\n";
        result += packItems(order) + "\n";
        result += generateShippingLabel(order) + "\n";
        return result;
    }

    protected abstract String verifyAvailability(Order order);

    protected abstract String packItems(Order order);

    private String generateShippingLabel(Order order) {
        return "Wygenerowano etykietę logistyczną dla zamówienia: " + order.getId();
    }
}
// Koniec, Tydzień 6, Wzorzec Template 1