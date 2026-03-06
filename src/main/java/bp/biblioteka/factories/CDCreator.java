package bp.biblioteka.factories;

public class CDCreator extends ItemCreator {
    @Override
    public Item createItem(String title, String band) {
        return new CD(title, band);
    }
}