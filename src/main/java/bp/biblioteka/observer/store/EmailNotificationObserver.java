package bp.biblioteka.observer.store;

import bp.biblioteka.entity.store.Store;

// Tydzień 6, Wzorzec Observer 1
public class EmailNotificationObserver implements StoreObserver {
    private String lastNotification;

    @Override
    public void update(Store store, String message) {
        lastNotification = "Wysyłanie e-maila dla sklepu " + store.getName() + ": " + message;
        System.out.println(lastNotification);
    }

    public String getLastNotification() {
        return lastNotification;
    }
}