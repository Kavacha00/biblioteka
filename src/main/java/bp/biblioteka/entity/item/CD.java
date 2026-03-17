package bp.biblioteka.entity.item;

import bp.biblioteka.bridge.ItemFormat;

public class CD extends Item {
    public CD(String author, String title, ItemFormat format) {
        super(author, title,  format);
    }

    @Override
    public String describe() {
        return "CD: " + this.getAuthor() + " | " + this.getTitle() + " [" + this.getFormat().format()+ "]";
    }
}
