package bp.biblioteka.factory.item;

import bp.biblioteka.bridge.item.ItemFormat;
import bp.biblioteka.entity.item.CD;
import bp.biblioteka.entity.item.Item;

public class CDCreator extends ItemCreator {
    private static CDCreator instance;
    private CDCreator() {super();}

    public static CDCreator getInstance() {
        if (instance == null) instance = new CDCreator();
        return instance;
    }
    @Override
    public Item createItem(String band, String title, ItemFormat format) {
        return new CD(band, title,  format);
    }
}