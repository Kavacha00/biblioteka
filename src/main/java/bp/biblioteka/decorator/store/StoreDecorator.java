package bp.biblioteka.decorator.store;

import bp.biblioteka.entity.store.Store;

public abstract class StoreDecorator extends Store {

    protected Store decoratedStore;

    public StoreDecorator(Store store) {
        super(store.getName(), store.getEmail(), store.getAddress(), store.getPhoneNumber());
        this.decoratedStore = store;
    }

    @Override
    public String processOrder() {
        return decoratedStore.processOrder();
    }
}