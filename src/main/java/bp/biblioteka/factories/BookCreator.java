package bp.biblioteka.factories;

public class BookCreator extends ItemCreator {
    @Override
    public Item createItem(String title, String author){
        return new Book(title, author);
    }
}
