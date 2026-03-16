package bp.biblioteka.decorator.store;

import bp.biblioteka.entity.store.Store;

public class PromotionDecorator extends StoreDecorator {

    public PromotionDecorator(Store store) {
        super(store);
    }

    @Override
    public String processOrder() {
        return decoratedStore.processOrder() + " + promotion applied";
    }
}