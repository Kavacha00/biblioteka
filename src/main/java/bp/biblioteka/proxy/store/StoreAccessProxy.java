package bp.biblioteka.proxy.store;

import bp.biblioteka.entity.store.Store;

import java.time.LocalTime;

public class StoreAccessProxy extends Store {

    private final Store realStore;

    public StoreAccessProxy(Store realStore) {
        super(realStore.getName(), realStore.getEmail(), realStore.getAddress(), realStore.getPhoneNumber());
        this.realStore = realStore;
    }

    @Override
    public String processOrder() {
        LocalTime now = LocalTime.now();

        if (now.isAfter(LocalTime.of(8,0)) && now.isBefore(LocalTime.of(16,0))) {
            return realStore.processOrder();
        }
        return "Store is closed. Order cannot be processed now.";
    }
}