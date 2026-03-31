package bp.biblioteka.memento.cart;

import bp.biblioteka.entity.item.Item;

import java.util.ArrayList;
import java.util.List;

public class CartMemento {
    private final List<Item> items;

    public CartMemento(List<Item> items) {
        this.items = new ArrayList<>(items);
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}
