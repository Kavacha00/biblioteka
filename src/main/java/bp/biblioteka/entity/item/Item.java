package bp.biblioteka.entity.item;

import bp.biblioteka.bridge.ItemFormat;

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

    public String getAuthor() { return this.author; }

    public ItemFormat getFormat() { return this.format; }

    public abstract String describe();
}
