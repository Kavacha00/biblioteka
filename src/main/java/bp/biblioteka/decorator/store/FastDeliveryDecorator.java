package bp.biblioteka.decorator.store;

import bp.biblioteka.entity.store.Store;

public class FastDeliveryDecorator extends StoreDecorator {

    public FastDeliveryDecorator(Store store) {
        super(store);
    }

    @Override
    public String processOrder() {
        return decoratedStore.processOrder() + " + fast delivery";
    }
}