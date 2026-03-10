package bp.biblioteka.entity.item;

import java.util.UUID;

public class Book extends Item implements Cloneable {
    public Book(String author, String title) {
        super(author, title);
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
        return "Book: " + this.getAuthor() + " | " + this.getTitle();
    }
}
