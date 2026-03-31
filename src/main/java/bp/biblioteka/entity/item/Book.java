package bp.biblioteka.entity.item;

import bp.biblioteka.bridge.item.ItemFormat;

import java.util.UUID;

public class Book extends Item implements Cloneable {
    public Book(String author, String title, ItemFormat format) {

        super(author, title,  format);
    }

    @Override
    public Book clone() {
        try {
            Book book = (Book) super.clone();
            book.id = UUID.randomUUID();
            return book;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String describe() {
        return "Book: " + this.getAuthor() + " | " + this.getTitle()
                + " [" + this.getFormat().format()+ "]";
    }

    @Override
    public String getInternalDetails() {
        return String.valueOf(this.getId());
    }



}
