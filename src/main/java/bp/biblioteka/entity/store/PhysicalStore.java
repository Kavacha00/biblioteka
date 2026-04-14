package bp.biblioteka.entity.store;

public class PhysicalStore extends Store {

    public PhysicalStore(String name, String email, String address, String phoneNumber) {
        super(name, email, address, phoneNumber);
    }

    @Override
    public String processOrder() {
        String result = "Processing order in physical store";
        // Tydzień 6, Wzorzec Observer 1
        // Powiadomienie obserwatorów o akcji
        notifyObservers(result);
        return result;
    }
}