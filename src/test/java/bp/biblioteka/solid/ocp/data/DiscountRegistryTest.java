package bp.biblioteka.solid.ocp.data;

import bp.biblioteka.solid.ocp.DiscountRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiscountRegistryTest {

    private DiscountRegistry registry;

    @BeforeEach
    void setup() {
        registry = new DiscountRegistry();
        registry.addDiscount("VIP", 0.8);
        registry.addDiscount("STUDENT", 0.9);
    }

    @Test
    void shouldApplyVipDiscountCorrectly() {
        double result = registry.applyDiscount("VIP", 100);

        assertEquals(80.0, result);
    }

    @Test
    void shouldApplyStudentDiscountCorrectly() {
        double result = registry.applyDiscount("STUDENT", 100);

        assertEquals(90.0, result);
    }

    @Test
    void shouldApplyDifferentDiscountsIndependently() {
        double vip = registry.applyDiscount("VIP", 200);
        double student = registry.applyDiscount("STUDENT", 200);

        assertEquals(160.0, vip);
        assertEquals(180.0, student);
    }

    @Test
    void shouldAllowAddingNewDiscountWithoutChangingLogic() {
        registry.addDiscount("BLACK_FRIDAY", 0.5);

        double result = registry.applyDiscount("BLACK_FRIDAY", 100);

        assertEquals(50.0, result);
    }

    @Test
    void shouldThrowExceptionForUnknownDiscountType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            registry.applyDiscount("UNKNOWN", 100);
        });

        assertTrue(exception.getMessage().contains("Unknown"));
    }

    @Test
    void shouldOverwriteExistingDiscount() {
        registry.addDiscount("VIP", 0.7);

        double result = registry.applyDiscount("VIP", 100);

        assertEquals(70.0, result);
    }
}