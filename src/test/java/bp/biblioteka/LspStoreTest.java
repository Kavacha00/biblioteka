package bp.biblioteka;

import bp.biblioteka.entity.store.OnlineStore;
import bp.biblioteka.entity.store.PhysicalStore;
import bp.biblioteka.entity.store.Store;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LspStoreTest {

    private void verifyStoreProcessing(Store store) {
        String processingResult = store.processOrder();

        assertNotNull(processingResult, "Wynik procesowania zamówienia nie może być null.");
        assertTrue(processingResult.contains("Processing order"), "Wynik powinien wskazywać na procesowanie zamówienia.");
    }

    @Test
    void shouldProcessOnlineStoreAsBaseStore() {
        Store onlineStore = new OnlineStore("E-Biblioteka", "sklep@online.pl", "Internet 1", "111-222-333");

        verifyStoreProcessing(onlineStore);
    }

    @Test
    void shouldProcessPhysicalStoreAsBaseStore() {
        Store physicalStore = new PhysicalStore("Biblioteka Główna", "sklep@lokalny.pl", "ul. Polna 5", "999-888-777");

        verifyStoreProcessing(physicalStore);
    }
}
