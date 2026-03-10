package bp.biblioteka.entity.store;

import java.util.UUID;

public class OnlineStore extends Store {

    public OnlineStore(String name, String email, String address, String phoneNumber) {
        super(name, email, address, phoneNumber);
    }

    @Override
    public String processOrder() {
        return "Processing order in online store";
    }
}
