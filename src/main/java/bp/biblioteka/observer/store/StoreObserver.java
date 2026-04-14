package bp.biblioteka.observer.store;

import bp.biblioteka.entity.store.Store;

// Tydzień 6, Wzorzec Observer 1
// Interfejs dla wszystkich obserwatorów nasłuchujących zdarzeń ze sklepu
public interface StoreObserver {
    void update(Store store, String message);
}