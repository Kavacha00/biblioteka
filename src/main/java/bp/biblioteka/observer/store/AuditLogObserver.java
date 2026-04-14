package bp.biblioteka.observer.store;

import bp.biblioteka.entity.store.Store;

// Tydzień 6, Wzorzec Observer 1
public class AuditLogObserver implements StoreObserver {
    private String lastLogEntry;

    @Override
    public void update(Store store, String message) {
        lastLogEntry = "AUDIT LOG [" + store.getId() + "]: " + message;
        System.out.println(lastLogEntry);
    }

    public String getLastLogEntry() {
        return lastLogEntry;
    }
}