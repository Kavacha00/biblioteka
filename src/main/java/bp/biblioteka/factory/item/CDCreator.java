package bp.biblioteka.factory.item;

import bp.biblioteka.bridge.item.ItemFormat;
import bp.biblioteka.entity.item.CD;
import bp.biblioteka.entity.item.Item;

//Tydzień 7, zasada otwarte - zamnkięte na abstrakcji 3
//stworzenie plyty CD na fabryce
public class CDCreator extends ItemCreator {
    private static CDCreator instance;
    private CDCreator() {super();}

    public static CDCreator getInstance() {
        if (instance == null) instance = new CDCreator();
        return instance;
    }
    @Override
    public Item createItem(String artist, String title, ItemFormat format) {
        return new CD(artist, title,  format);
    }
}