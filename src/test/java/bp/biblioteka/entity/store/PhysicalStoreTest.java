package bp.biblioteka.entity.store;

import bp.biblioteka.factory.store.PhysicalStoreCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class PhysicalStoreTest {
    @Test
    void shouldClonePhysicalStoreWithCorrectFields() {
        var factory = PhysicalStoreCreator.getInstance();
        Store store = factory.createStore("Physical Store", "store@example.com", "123 Main St", "555-1234");
        Store clone = store.clone();

        assertNotSame(store, clone);
        assertEquals(store.getId(), clone.getId());
        assertEquals(store.getName(), clone.getName());
        assertEquals(store.getEmail(), clone.getEmail());
        assertEquals(store.getAddress(), clone.getAddress());
        assertEquals(store.getPhoneNumber(), clone.getPhoneNumber());
        assertEquals(store.getClass(), clone.getClass());

    }
}
