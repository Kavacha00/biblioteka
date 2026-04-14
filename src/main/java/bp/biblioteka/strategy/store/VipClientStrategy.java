// Tydzień 6, Wzorzec Strategy 1
// Konkretna implementacja strategii dla klienta VIP.
// Oblicza cenę pomniejszoną o 35% zniżki lojalnościowej.
package bp.biblioteka.strategy.store;

public class VipClientStrategy implements DiscountStrategy {

    @Override
    public double calculateDiscount(double price) {
        return price * 0.65;
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy 1