// Tydzień 6, Wzorzec Strategy 1
// Konkretna implementacja strategii dla zwykłego klienta.
// Zwraca pełną cenę bez żadnych zniżek.
package bp.biblioteka.strategy.store;

public class RegularClientStrategy implements DiscountStrategy {

    @Override
    public double calculateDiscount(double price) {
        return price;
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy 1