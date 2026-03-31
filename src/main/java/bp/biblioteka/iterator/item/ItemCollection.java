package bp.biblioteka.iterator.item;

import bp.biblioteka.entity.item.Item;

public interface ItemCollection {
    void addItem(Item item);
    void removeItem(Item item);
    ItemIterator itemAuthorIterator(String author);
}
