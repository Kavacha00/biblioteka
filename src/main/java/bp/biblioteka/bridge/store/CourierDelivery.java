package bp.biblioteka.bridge.store;

public class CourierDelivery implements DeliveryMethod {

    @Override
    public String deliver() {
        return "Delivered by courier";
    }
}
