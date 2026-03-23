package bp.biblioteka.bridge.store;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeStoreTest {

    @Test
    void shouldProcessOrderWithCourierDelivery() {
        DeliveryMethod delivery = new CourierDelivery();
        BridgeStore store = new BridgeStore(
                "Store", "mail", "addr", "123", delivery
        );

        String result = store.processOrder();

        assertEquals("Processing order + Delivered by courier", result);
    }

    @Test
    void shouldProcessOrderWithParcelLockerDelivery() {
        DeliveryMethod delivery = new ParcelLockerDelivery();
        BridgeStore store = new BridgeStore(
                "Store", "mail", "addr", "123", delivery
        );

        String result = store.processOrder();

        assertEquals("Processing order + Delivered to parcel locker", result);
    }

    @Test
    void shouldAllowChangingImplementationIndependently() {
        DeliveryMethod delivery1 = new CourierDelivery();
        DeliveryMethod delivery2 = new ParcelLockerDelivery();

        BridgeStore store1 = new BridgeStore("S1", "m", "a", "1", delivery1);
        BridgeStore store2 = new BridgeStore("S2", "m", "a", "1", delivery2);

        String result1 = store1.processOrder();
        String result2 = store2.processOrder();

        assertNotEquals(result1, result2);
    }
}
