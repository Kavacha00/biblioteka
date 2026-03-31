package bp.biblioteka.memento.cart;

import bp.biblioteka.entity.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void showCart() {
        System.out.println(items);
    }

    public CartMemento save() {
        return new CartMemento(items);
    }

    public void restore(CartMemento memento) {
        items = memento.getItems();
    }

}
