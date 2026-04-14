// Tydzień 6, Wzorzec Template 1
// Implementacja konkretnych kroków algorytmu dla zamówienia fizycznego.
// Dostarcza logikę pakowania i weryfikacji fizycznych produktów magazynowych.
package bp.biblioteka.template.store;

import bp.biblioteka.entity.store.Order;

public class PhysicalOrderProcessor extends OrderProcessor {

    @Override
    protected String verifyAvailability(Order order) {
        return "Sprawdzono fizyczny stan magazynowy na półkach.";
    }

    @Override
    protected String packItems(Order order) {
        return "Zapakowano książki do kartonowego pudełka.";
    }
}
// Koniec, Tydzień 6, Wzorzec Template 1