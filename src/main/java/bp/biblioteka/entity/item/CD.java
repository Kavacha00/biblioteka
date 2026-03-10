package bp.biblioteka.entity.item;

public class CD extends Item {
    public CD(String author, String title) {
        super(author, title);
    }

    @Override
    public String describe() {
        return "CD: " + this.getAuthor() + " | " + this.getTitle();
    }
}
