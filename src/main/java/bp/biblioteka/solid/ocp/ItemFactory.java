package bp.biblioteka.solid.ocp;

import bp.biblioteka.bridge.item.ItemFormat;
import bp.biblioteka.entity.item.Item;

public interface ItemFactory {
    Item create(String artist, String title, ItemFormat format);
}
