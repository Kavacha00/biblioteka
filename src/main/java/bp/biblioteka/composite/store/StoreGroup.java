package bp.biblioteka.composite.store;

import bp.biblioteka.entity.store.Store;

import java.util.ArrayList;
import java.util.List;

public class StoreGroup extends Store {

    private List<Store> stores = new ArrayList<>();

    public StoreGroup(String name, String email, String address, String phoneNumber) {
        super(name, email, address, phoneNumber);
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    public void removeStore(Store store) {
        stores.remove(store);
    }

    @Override
    public String processOrder() {

        StringBuilder result = new StringBuilder();

        for (Store store : stores) {
            result.append(store.processOrder()).append("\n");
        }

        return result.toString();
    }
}
