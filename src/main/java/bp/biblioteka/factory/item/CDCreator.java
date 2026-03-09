package bp.biblioteka.factory.item;

import bp.biblioteka.entity.item.CD;
import bp.biblioteka.entity.item.Item;

public class CDCreator extends ItemCreator {
    @Override
    public Item createItem(String title, String band) {
        return new CD(title, band);
    }
}