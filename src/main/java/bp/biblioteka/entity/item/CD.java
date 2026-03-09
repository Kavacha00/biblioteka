package bp.biblioteka.entity.item;

public class CD extends Item {
    public CD(String title, String author) {
        super(title, author);
    }

    @Override
    public String describe() {
        return "CD: " + this.getTitle() + " | " + this.getAuthor();
    }
}
