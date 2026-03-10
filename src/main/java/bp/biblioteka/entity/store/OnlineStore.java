package bp.biblioteka.entity.store;

public class OnlineStore extends Store {

    public OnlineStore(String name, String email, String address, String phoneNumber) {
        super(name, email, address, phoneNumber);
    }

    @Override
    public String processOrder() {
        return "Processing order in online store";
    }
}
