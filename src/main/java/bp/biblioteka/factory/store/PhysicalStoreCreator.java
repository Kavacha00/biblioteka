package bp.biblioteka.factory.store;

import bp.biblioteka.entity.store.PhysicalStore;
import bp.biblioteka.entity.store.Store;



public final class PhysicalStoreCreator extends StoreCreator {

    // Tydzień 2, Wzorzec Singleton 1
    // Wzorzec Singleton gwarantuje, że w całej aplikacji będzie istniała tylko jedna instancja tej klasy.
    // Zastosowano tutaj mechanizm podwójnego zatwierdzenia (Double-Checked Locking) z operatorem volatile,
    // co zapewnia bezpieczne działanie w środowisku wielowątkowym.

    private static volatile PhysicalStoreCreator instance;

    private PhysicalStoreCreator() {
        super();
    }

    public static PhysicalStoreCreator getInstance() {
        PhysicalStoreCreator result = instance;
        if (result!= null) {
            return result;
        }
        synchronized(PhysicalStoreCreator.class) {
            if (instance == null) {
                instance = new PhysicalStoreCreator();
            }
            return instance;
        }
    }

    // Koniec, Tydzień 2, Wzorzec Singleton 1

    @Override
    public Store createStore(String name, String email, String address, String phoneNumber) {
        return new PhysicalStore(name, email, address, phoneNumber);
    }
}
