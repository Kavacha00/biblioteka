package bp.biblioteka.composite.store;

import bp.biblioteka.entity.store.PhysicalStore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreGroupTest {

    @Test
    void shouldProcessOrdersFromAllStores() {
        StoreGroup group = new StoreGroup("Group", "mail", "addr", "123");

        var store1 = new PhysicalStore("Store1", "mail1", "addr1", "111");
        var store2 = new PhysicalStore("Store2", "mail2", "addr2", "222");

        group.addStore(store1);
        group.addStore(store2);

        String result = group.processOrder();

        assertTrue(result.contains("Processing order in physical store"));

        assertEquals(2, result.split("\n").length);
    }

    @Test
    void shouldReturnEmptyStringWhenNoStores() {
        StoreGroup group = new StoreGroup("Group", "mail", "addr", "123");

        String result = group.processOrder();

        assertEquals("", result);
    }

    @Test
    void shouldRemoveStoreCorrectly() {
        StoreGroup group = new StoreGroup("Group", "mail", "addr", "123");

        var store = new PhysicalStore("Store1", "mail1", "addr1", "111");

        group.addStore(store);
        group.removeStore(store);

        String result = group.processOrder();

        assertEquals("", result);
    }

    @Test
    void shouldHandleSingleStore() {
        StoreGroup group = new StoreGroup("Group", "mail", "addr", "123");

        var store = new PhysicalStore("Store1", "mail1", "addr1", "111");

        group.addStore(store);

        String result = group.processOrder();

        assertEquals("Processing order in physical store\n", result);
    }
}