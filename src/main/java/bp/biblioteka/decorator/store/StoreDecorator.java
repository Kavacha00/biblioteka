package bp.biblioteka.decorator.store;

import bp.biblioteka.entity.store.Store;

//Tydzień 3, Wzorzec Decorator 1,
// Wzorzec Decorator pozwala dynamicznie rozszerzać zachowanie obiektu
// poprzez opakowanie go w obiekt dekoratora bez zmiany jego klasy bazowej.
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
//Koniec, Tydzień 3, Wzorzec Decorator 1