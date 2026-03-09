package bp.biblioteka.entity.item;

public class Book extends Item {
    public Book(String author, String title) {
        super(title, author);
    }

    @Override
    public String describe() {
        return "Book: " + this.getTitle() + " | " + this.getAuthor();
    }
}
