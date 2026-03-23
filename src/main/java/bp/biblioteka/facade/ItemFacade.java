package bp.biblioteka.facade;

import bp.biblioteka.bridge.DigitalFormat;
import bp.biblioteka.bridge.ItemFormat;
import bp.biblioteka.bridge.PhysicalFormat;
import bp.biblioteka.composite.AuthorCollection;
import bp.biblioteka.decorator.BestsellerDecorator;
import bp.biblioteka.entity.item.Item;
import bp.biblioteka.factory.item.BookCreator;

public class ItemFacade {
    private final BookCreator bookCreator;
    private final ItemFormat physicalFormat;
    private final ItemFormat digitalFormat;

    public  ItemFacade() {
        this.bookCreator = BookCreator.getInstance();
        this.physicalFormat = new PhysicalFormat();
        this.digitalFormat = new DigitalFormat();
    }

    public Item createPhysicalBook(String author, String title){
        return bookCreator.createItem(author, title,  physicalFormat);
    }

    public Item createDigitalBook(String author, String title){
        return bookCreator.createItem(author, title,  digitalFormat);
    }

    public Item createBestsellerBook(String author, String title, boolean isDigital){
        Item book = isDigital ? createDigitalBook(author, title) : createPhysicalBook(author, title);
        return new BestsellerDecorator(book);
    }

    public AuthorCollection createAuthorCollection(String author){
        return new AuthorCollection(author);
    }
}
