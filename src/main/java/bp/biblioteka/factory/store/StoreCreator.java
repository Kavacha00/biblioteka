package bp.biblioteka.factory.store;

import bp.biblioteka.entity.store.Store;

public abstract class StoreCreator {
    public abstract Store createStore(String name, String email, String address, String phoneNumber);
}
