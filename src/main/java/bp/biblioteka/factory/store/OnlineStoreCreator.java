package bp.biblioteka.factory.store;

import bp.biblioteka.entity.store.OnlineStore;
import bp.biblioteka.entity.store.Store;

public class OnlineStoreCreator extends StoreCreator {

    @Override
    public Store createStore(String name, String email, String address, String phoneNumber) {
        return new OnlineStore(name, email, address, phoneNumber);
    }
}
