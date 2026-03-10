package bp.biblioteka.factory.item;

import bp.biblioteka.entity.item.CD;
import bp.biblioteka.entity.item.Item;

public class CDCreator extends ItemCreator {
    @Override
    public Item createItem(String band, String title) {
        return new CD(band, title);
    }
}