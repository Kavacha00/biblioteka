package bp.biblioteka.observer.store;

import bp.biblioteka.entity.store.OnlineStore;
import bp.biblioteka.entity.store.PhysicalStore;
import bp.biblioteka.entity.store.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StoreObserverTest {

    private Store onlineStore;
    private Store physicalStore;
    private EmailNotificationObserver emailObserver;
    private AuditLogObserver auditObserver;

    @BeforeEach
    void setUp() {
        onlineStore = new OnlineStore("Empik", "kontakt@empik.com", "Marszałkowska 104", "123-456-789");
        physicalStore = new PhysicalStore("Biblioteka Miejska", "bib@miasto.pl", "Rynek 1", "987-654-321");

        emailObserver = new EmailNotificationObserver();
        auditObserver = new AuditLogObserver();
    }

    @Test
    void shouldNotifyAllObserversWhenOnlineStoreProcessesOrder() {
        onlineStore.addObserver(emailObserver);
        onlineStore.addObserver(auditObserver);

        onlineStore.processOrder();

        assertNotNull(emailObserver.getLastNotification());
        assertTrue(emailObserver.getLastNotification()
                .contains("Wysyłanie e-maila dla sklepu Empik: Processing order in online store"));

        assertNotNull(auditObserver.getLastLogEntry());
        assertTrue(auditObserver.getLastLogEntry()
                .contains("AUDIT LOG [" + onlineStore.getId() + "]: Processing order in online store"));
    }

    @Test
    void shouldNotNotifyRemovedObserver() {
        physicalStore.addObserver(emailObserver);
        physicalStore.addObserver(auditObserver);

        physicalStore.removeObserver(emailObserver);

        physicalStore.processOrder();

        assertNull(emailObserver.getLastNotification(), "Usunięty obserwator nie powinien otrzymać powiadomienia");

        assertNotNull(auditObserver.getLastLogEntry());
        assertTrue(auditObserver.getLastLogEntry()
                .contains("Processing order in physical store"));
    }
}