// Tydzień 6, Wzorzec Template 1
// Implementacja konkretnych kroków algorytmu dla zamówienia cyfrowego (np. e-book).
// Dostarcza logikę generowania linków i weryfikacji licencji.
package bp.biblioteka.template.store;

import bp.biblioteka.entity.store.Order;

public class DigitalOrderProcessor extends OrderProcessor {

    @Override
    protected String verifyAvailability(Order order) {
        return "Zweryfikowano dostępność licencji cyfrowych na serwerze.";
    }

    @Override
    protected String packItems(Order order) {
        return "Wygenerowano bezpieczne linki do pobrania plików.";
    }
}
// Koniec, Tydzień 6, Wzorzec Template 1