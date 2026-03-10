package bp.biblioteka.factory.item;

import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.item.Item;

public final class BookCreator extends ItemCreator {
    private static volatile  BookCreator instance;
    private BookCreator() {
        super();
    }
    public static BookCreator getInstance() {
        if (instance == null) {
            synchronized (BookCreator.class) {
                if (instance == null) {
                    instance = new BookCreator();
                }
            }
        }
        return instance;
    }

    @Override
    public Item createItem(String author, String title){
        return new Book(author, title);
    }
}
