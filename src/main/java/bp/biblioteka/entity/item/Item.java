package bp.biblioteka.entity.item;

import java.util.UUID;

public abstract class Item {
    protected UUID id;
    private String title;
    private String author;

    public Item(String title, String author) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.author = author;
    }

    public UUID getId() {
        return this.id;
    }
    public String getTitle() {
        return this.title;
    }

    public String getAuthor() { return this.author; }

    public abstract String describe();
}
