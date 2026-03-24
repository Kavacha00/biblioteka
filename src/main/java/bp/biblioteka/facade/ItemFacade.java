package bp.biblioteka.facade;

import bp.biblioteka.bridge.item.DigitalFormat;
import bp.biblioteka.bridge.item.ItemFormat;
import bp.biblioteka.bridge.item.PhysicalFormat;
import bp.biblioteka.composite.item.AuthorCollection;
import bp.biblioteka.decorator.Item.BestsellerDecorator;
import bp.biblioteka.entity.item.Item;
import bp.biblioteka.factory.item.BookCreator;
import bp.biblioteka.flyweight.item.FormatFactory;

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
        ItemFormat itemFormat = FormatFactory.getItemFormat("physical");
        return bookCreator.createItem(author, title,  itemFormat);
    }

    public Item createDigitalBook(String author, String title){
        ItemFormat itemFormat = FormatFactory.getItemFormat("digital");
        return bookCreator.createItem(author, title,  itemFormat);
    }

    public Item createBestsellerBook(String author, String title, boolean isDigital){
        Item book = isDigital ? createDigitalBook(author, title) : createPhysicalBook(author, title);
        return new BestsellerDecorator(book);
    }

    public AuthorCollection createAuthorCollection(String author){
        return new AuthorCollection(author);
    }
}
