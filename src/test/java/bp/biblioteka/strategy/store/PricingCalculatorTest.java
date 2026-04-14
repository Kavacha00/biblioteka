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