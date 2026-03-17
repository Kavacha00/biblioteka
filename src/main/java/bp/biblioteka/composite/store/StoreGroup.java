package bp.biblioteka.composite.store;

import bp.biblioteka.entity.store.Store;

import java.util.ArrayList;
import java.util.List;

//Tydzień 3, Wzorzec Composite 1,
// Wzorzec Composite pozwala traktować pojedyncze obiekty oraz ich grupy w jednolity sposób.
// StoreGroup agreguje wiele obiektów Store i deleguje do nich operacje.
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
//Koniec, Tydzień 3, Wzorzec Composite 1
