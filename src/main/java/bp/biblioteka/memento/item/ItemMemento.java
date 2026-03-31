package bp.biblioteka.memento.item;

//Tydzień 5, Wzorzec Memento 3
//Możliwość cofania zmian
public class ItemMemento {

    private String title;
    private String author;

    public ItemMemento(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}