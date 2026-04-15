// Tydzień 6, Wzorzec Strategy 1
// Wzorzec Strategy definiujący wspólny interfejs dla różnych algorytmów obliczania zniżek.
// Pozwala na uniezależnienie algorytmu od klienta, który go używa.
package bp.biblioteka.strategy.store;

public interface DiscountStrategy {
    double calculateDiscount(double price);
}
// Koniec, Tydzień 6, Wzorzec Strategy 1