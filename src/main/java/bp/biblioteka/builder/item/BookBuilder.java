package bp.biblioteka.builder.item;

import bp.biblioteka.bridge.ItemFormat;
import bp.biblioteka.entity.item.Book;

public class BookBuilder {
    private String author;
    private String title;
    private ItemFormat format;

    public void reset(){
        this.author = null;
        this.title = null;
        this.format = null;
    }

    public BookBuilder author(String author){
        this.author = author;
        return this;
    }

    public BookBuilder title(String title){
        this.title = title;
        return this;
    }

    public BookBuilder format(ItemFormat format){
        this.format = format;
        return this;
    }

    public Book build(){
        String bookAuthor = this.author;
        String bookTitle = this.title;
        ItemFormat bookFormat = this.format;
        this.reset();
        return new Book(bookAuthor, bookTitle,  bookFormat);
    }
}
