package bp.biblioteka.decorator.store;

import bp.biblioteka.entity.store.PhysicalStore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreDecoratorTest {

    @Test
    void shouldAddFastDeliveryToOrder() {
        var store = new PhysicalStore("Store", "mail", "addr", "123");
        var decorated = new FastDeliveryDecorator(store);

        String result = decorated.processOrder();

        assertEquals("Processing order in physical store + fast delivery", result);
    }

    @Test
    void shouldAddPromotionToOrder() {
        var store = new PhysicalStore("Store", "mail", "addr", "123");
        var decorated = new PromotionDecorator(store);

        String result = decorated.processOrder();

        assertEquals("Processing order in physical store + promotion applied", result);
    }

    @Test
    void shouldCombineMultipleDecorators() {
        var store = new PhysicalStore("Store", "mail", "addr", "123");

        var decorated = new PromotionDecorator(
                new FastDeliveryDecorator(store)
        );

        String result = decorated.processOrder();

        assertEquals(
                "Processing order in physical store + fast delivery + promotion applied",
                result
        );
    }

    @Test
    void shouldPreserveBaseBehavior() {
        var store = new PhysicalStore("Store", "mail", "addr", "123");

        String baseResult = store.processOrder();

        assertEquals("Processing order in physical store", baseResult);
    }
}