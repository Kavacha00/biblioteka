package bp.biblioteka.factory.store;

import bp.biblioteka.entity.store.PhysicalStore;
import bp.biblioteka.entity.store.Store;

public class PhysicalStoreCreator extends StoreCreator {

    @Override
    public Store createStore(String name, String email, String address, String phoneNumber) {
        return new PhysicalStore(name, email, address, phoneNumber);
    }
}
