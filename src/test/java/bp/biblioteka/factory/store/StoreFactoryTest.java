package bp.biblioteka.factory.store;

import bp.biblioteka.entity.store.OnlineStore;
import bp.biblioteka.entity.store.PhysicalStore;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StoreFactoryTest {
    @Test
    void shouldCreateOnlineStoreUsingOnlineStoreFactory() {
        OnlineStoreCreator factory = new OnlineStoreCreator();

        var store = factory.createStore("Online Store", "store@example.com", "www.onlinestore.com", "555-1234");
        assertFalse(store instanceof PhysicalStore);
        assertInstanceOf(OnlineStore.class, store);
    }

    @Test
    void shouldCreatePhysicalStoreUsingPhysicalStoreFactory() {
        PhysicalStoreCreator factory = PhysicalStoreCreator.getInstance();

        var store = factory.createStore("Physical Store", "store@example.com", "123 Main St", "555-1234");
        assertFalse(store instanceof OnlineStore);
        assertInstanceOf(PhysicalStore.class, store);
    }

    @Test
    void shouldCreateOnlineStoreWithCorrectFields() {
        OnlineStoreCreator factory = new OnlineStoreCreator();

        var store = factory.createStore("Online Store", "store@example.com", "www.onlinestore.com", "555-1234");
        assertEquals("Online Store", store.getName());
        assertEquals("store@example.com", store.getEmail());
        assertEquals("www.onlinestore.com", store.getAddress());
        assertEquals("555-1234", store.getPhoneNumber());
    }

    @Test
    void shouldCreatePhysicalStoreWithCorrectFields() {
        PhysicalStoreCreator factory = PhysicalStoreCreator.getInstance();

        var store = factory.createStore("Physical Store", "store@example.com", "123 Main St", "555-1234");
        assertEquals("Physical Store", store.getName());
        assertEquals("store@example.com", store.getEmail());
        assertEquals("123 Main St", store.getAddress());
        assertEquals("555-1234", store.getPhoneNumber());
    }

    @Test
    void shouldReturnSameInstanceOfPhysicalStoreCreator() {
        PhysicalStoreCreator factory1 = PhysicalStoreCreator.getInstance();
        PhysicalStoreCreator factory2 = PhysicalStoreCreator.getInstance();

        assertSame(factory1, factory2);
    }

}
