package bp.biblioteka.iterator.item;

import bp.biblioteka.entity.item.Item;

public interface ItemIterator {
    boolean hasNext();
    Item next();
    void reset();
}
