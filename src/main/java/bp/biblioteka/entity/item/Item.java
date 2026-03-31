package bp.biblioteka.entity.item;

import bp.biblioteka.bridge.item.ItemFormat;
import bp.biblioteka.memento.item.ItemMemento;

import java.util.Objects;
import java.util.UUID;

public abstract class Item {
    protected UUID id;
    private String title;
    private String author;



    protected ItemFormat format;

    public Item(String author, String title,  ItemFormat format) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.author = author;
        this.format = format;
    }

    public UUID getId() {
        return this.id;
    }
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() { return this.author; }

    public ItemFormat getFormat() { return this.format; }

    public abstract String describe();

    public String getInternalDetails(){
        return " | " + this.getId();
    }

    public ItemMemento saveStateToMemento(){
        return new ItemMemento(this.title, this.author);
    }

    public void restoreStateFromMemento(ItemMemento memento){
        this.title = memento.getTitle();
        this.author = memento.getAuthor();
    }

    public boolean isBorrowed = false;
    public boolean isBorrowed() {
        return isBorrowed;
    }
    public void setBorrowed(boolean borrowed) {
        this.isBorrowed = borrowed;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) && Objects.equals(title, item.title) && Objects.equals(author, item.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author);
    }
}
