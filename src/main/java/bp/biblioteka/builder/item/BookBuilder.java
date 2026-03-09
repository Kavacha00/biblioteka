package bp.biblioteka.builder.item;

import bp.biblioteka.entity.item.Book;

public class BookBuilder {
    private String author;
    private String title;

    public void reset(){
        this.author = null;
        this.title = null;
    }

    public BookBuilder author(String author){
        this.author = author;
        return this;
    }

    public BookBuilder title(String title){
        this.title = title;
        return this;
    }

    public Book build(){
        String bookAuthor = this.author;
        String bookTitle = this.title;
        this.reset();
        return new Book(bookAuthor, bookTitle);
    }
}
