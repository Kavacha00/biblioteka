// Tydzień 6, Wzorzec Strategy 1
// Klasa Context (kalkulator cen) wykorzystująca wstrzykniętą strategię.
// Deleguje logikę obliczania końcowej kwoty do obiektu DiscountStrategy.
package bp.biblioteka.strategy.store;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PricingCalculator {
    private DiscountStrategy discountStrategy;

    public PricingCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateFinalPrice(double basePrice) {
        return discountStrategy.calculateDiscount(basePrice);
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy 1