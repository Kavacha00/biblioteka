package bp.biblioteka.factory.item;

import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.item.Item;

public class BookCreator extends ItemCreator {
    @Override
    public Item createItem(String title, String author){
        return new Book(title, author);
    }
}
