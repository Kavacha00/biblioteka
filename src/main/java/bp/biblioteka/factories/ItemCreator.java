package bp.biblioteka.factories;

public abstract class ItemCreator {
    public abstract Item createItem(String title, String creator);

    public Item orderItem(String title, String creator) {
        Item item = createItem(title, creator);
        return item;
    }
}
