package bp.biblioteka.visitor.store;

import bp.biblioteka.entity.store.OnlineStore;
import bp.biblioteka.entity.store.PhysicalStore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreVisitorTest {

    @Test
    void shouldGenerateAuditForPhysicalStore() {
        PhysicalStore physicalStore = new PhysicalStore("Księgarnia Główna", "kontakt@ksiegarnia.pl", "ul. Długa 5", "111-222-333");
        StoreAuditVisitor visitor = new StoreAuditVisitor();

        visitor.visit(physicalStore);

        assertEquals("Audyt fizyczny dla: Księgarnia Główna, Adres: ul. Długa 5", visitor.getAuditResult());
    }

    @Test
    void shouldGenerateAuditForOnlineStore() {
        OnlineStore onlineStore = new OnlineStore("E-Książki", "sklep@eksiazki.pl", "ul. Wirtualna 1", "444-555-666");
        StoreAuditVisitor visitor = new StoreAuditVisitor();

        visitor.visit(onlineStore);

        assertEquals("Audyt cyfrowy dla: E-Książki, Email: sklep@eksiazki.pl", visitor.getAuditResult());
    }
}