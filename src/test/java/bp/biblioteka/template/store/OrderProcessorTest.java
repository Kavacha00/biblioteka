package bp.biblioteka.template.store;

import bp.biblioteka.entity.store.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderProcessorTest {

    @Test
    void shouldProcessPhysicalOrderUsingTemplate() {
        Order order = new Order();
        OrderProcessor processor = new PhysicalOrderProcessor();

        String result = processor.processOrder(order);

        assertTrue(result.contains("Sprawdzono fizyczny stan magazynowy na półkach."));
        assertTrue(result.contains("Zapakowano książki do kartonowego pudełka."));
        assertTrue(result.contains("Wygenerowano etykietę logistyczną dla zamówienia: " + order.getId()));
    }

    @Test
    void shouldProcessDigitalOrderUsingTemplate() {
        Order order = new Order();
        OrderProcessor processor = new DigitalOrderProcessor();

        String result = processor.processOrder(order);

        assertTrue(result.contains("Zweryfikowano dostępność licencji cyfrowych na serwerze."));
        assertTrue(result.contains("Wygenerowano bezpieczne linki do pobrania plików."));
        assertTrue(result.contains("Wygenerowano etykietę logistyczną dla zamówienia: " + order.getId()));
    }
}