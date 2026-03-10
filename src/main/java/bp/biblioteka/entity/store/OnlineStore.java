package bp.biblioteka.entity.store;

import java.util.UUID;

public class OnlineStore extends Store implements Cloneable {

    public OnlineStore(String name, String email, String address, String phoneNumber) {
        super(name, email, address, phoneNumber);
    }

    @Override
    public OnlineStore clone() {
        try {
            OnlineStore onlineStore = (OnlineStore) super.clone();
            onlineStore.id = UUID.randomUUID();
            return onlineStore;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String processOrder() {
        return "Processing order in online store";
    }
}
