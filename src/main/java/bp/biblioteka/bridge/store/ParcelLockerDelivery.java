package bp.biblioteka.bridge.store;


public class ParcelLockerDelivery implements DeliveryMethod {

    @Override
    public String deliver() {
        return "Delivered to parcel locker";
    }
}
