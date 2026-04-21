package bp.biblioteka.solid.ocp.data;

import bp.biblioteka.solid.ocp.PenaltyRegistry;
import bp.biblioteka.strategy.item.PenaltyStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PenaltyRegistryTest {

    @BeforeEach
    void setup() {
        PenaltyRegistry.register("STANDARD", days -> days * 2.0);
        PenaltyRegistry.register("HIGH", days -> 10.0 + days * 5.0);
    }

    @Test
    void shouldReturnCorrectStrategy() {
        PenaltyStrategy strategy = PenaltyRegistry.getStrategy("STANDARD");

        assertNotNull(strategy);
    }

    @Test
    void shouldCalculateStandardPenaltyCorrectly() {
        PenaltyStrategy strategy = PenaltyRegistry.getStrategy("STANDARD");

        double result = strategy.calculatePenalty(3);

        assertEquals(6.0, result);
    }

    @Test
    void shouldCalculateHighPenaltyCorrectly() {
        PenaltyStrategy strategy = PenaltyRegistry.getStrategy("HIGH");

        double result = strategy.calculatePenalty(3);

        assertEquals(25.0, result);
    }

    @Test
    void shouldThrowExceptionForUnknownStrategy() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PenaltyRegistry.getStrategy("UNKNOWN");
        });

        assertTrue(exception.getMessage().contains("Unknown penalty"));
    }
}