// Tydzień 6, Wzorzec Strategy 1
// Testy jednostkowe weryfikujące poprawność działania poszczególnych strategii zniżkowych.
// Sprawdzają czy zmiana strategii w locie poprawnie wpływa na wynik kalkulacji.
package bp.biblioteka.strategy.store;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricingCalculatorTest {

    @Test
    void shouldCalculatePriceWithDifferentStrategies() {
        double basePrice = 100.0;

        PricingCalculator calculator = new PricingCalculator(new RegularClientStrategy());
        assertEquals(100.0, calculator.calculateFinalPrice(basePrice));

        calculator.setDiscountStrategy(new StudentClientStrategy());
        assertEquals(80.0, calculator.calculateFinalPrice(basePrice));

        calculator.setDiscountStrategy(new VipClientStrategy());
        assertEquals(65.0, calculator.calculateFinalPrice(basePrice));
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy 1