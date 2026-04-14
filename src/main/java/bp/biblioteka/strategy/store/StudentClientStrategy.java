// Tydzień 6, Wzorzec Strategy 1
// Konkretna implementacja strategii dla studenta.
// Oblicza cenę pomniejszoną o 20% zniżki studenckiej.
package bp.biblioteka.strategy.store;

public class StudentClientStrategy implements DiscountStrategy {

    @Override
    public double calculateDiscount(double price) {
        return price * 0.80;
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy 1