package bp.biblioteka.bridge.store;

import bp.biblioteka.entity.store.Store;

//Tydzień 3, Wzorzec Bridge 1,
// Wzorzec Bridge oddziela abstrakcję (Store) od implementacji (DeliveryMethod),
// dzięki czemu można niezależnie zmieniać sposób dostawy bez modyfikacji klasy Store.
public class BridgeStore extends Store {

    protected DeliveryMethod deliveryMethod;

    public BridgeStore(String name, String email, String address, String phoneNumber,
                       DeliveryMethod deliveryMethod) {
        super(name, email, address, phoneNumber);
        this.deliveryMethod = deliveryMethod;
    }

    @Override
    public String processOrder() {
        return "Processing order + " + deliveryMethod.deliver();
    }
}
//Koniec, Tydzień 3, Wzorzec Bridge 1