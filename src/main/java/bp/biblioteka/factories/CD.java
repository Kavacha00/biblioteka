package bp.biblioteka.factories;

public class CD extends Item{

    private String author;

    public CD(String title, String author) {
        super(title);
        this.author = author;
    }
    @Override
    public void displayDetails() {
        System.out.println(getTitle() + author);
    }
}
