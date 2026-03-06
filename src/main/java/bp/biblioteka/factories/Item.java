package bp.biblioteka.factories;

import java.util.UUID;

public abstract class Item {
    private UUID id;
    private String title;

    public Item(String title) {
        this.id = UUID.randomUUID();
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public abstract void displayDetails();
}
