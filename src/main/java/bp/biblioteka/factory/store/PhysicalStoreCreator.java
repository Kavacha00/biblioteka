package bp.biblioteka.factory.store;

import bp.biblioteka.entity.store.PhysicalStore;
import bp.biblioteka.entity.store.Store;

public final class PhysicalStoreCreator extends StoreCreator {

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

    @Override
    public Store createStore(String name, String email, String address, String phoneNumber) {
        return new PhysicalStore(name, email, address, phoneNumber);
    }
}
