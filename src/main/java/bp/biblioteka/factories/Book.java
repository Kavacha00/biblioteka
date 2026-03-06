package bp.biblioteka.factories;

import java.util.UUID;

public class Book extends Item{
    private String author;

    public Book(String author, String title) {
        super(title);
        this.author = author;
    }

    @Override
    public void displayDetails() {
        System.out.println(getTitle() + author);
    }
}
