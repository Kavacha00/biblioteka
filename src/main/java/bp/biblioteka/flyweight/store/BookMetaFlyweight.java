package bp.biblioteka.flyweight.store;

//Tydzień 4, Wzorzec Flyweight 1
//Flyweight dla metadanych książki
//Przechowuje współdzielone dane: autora, tytuł i format
public class BookMetaFlyweight {

    private final String author;
    private final String title;
    private final String format;

    public BookMetaFlyweight(String author, String title, String format) {
        this.author = author;
        this.title = title;
        this.format = format;
    }

    public String getInfo() {
        return author + " — " + title + " [" + format + "]";
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight 1