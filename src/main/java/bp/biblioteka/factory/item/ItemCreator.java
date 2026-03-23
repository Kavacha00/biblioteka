package bp.biblioteka.factory.item;

import bp.biblioteka.bridge.item.ItemFormat;
import bp.biblioteka.entity.item.Item;

public abstract class ItemCreator {
    public abstract Item createItem(String creator, String title,  ItemFormat format);
}
