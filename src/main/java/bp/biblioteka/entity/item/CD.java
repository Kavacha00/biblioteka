package bp.biblioteka.entity.item;

import bp.biblioteka.bridge.item.ItemFormat;

//Tydzień 7, zasada otwarte - zamnkięte na abstrakcji 2
//dodanie nowego przedmiotu jakim jest płyta CD
public class CD extends Item {
    public CD(String artist, String title, ItemFormat format) {
        super(artist, title,  format);
    }

    @Override
    public String describe() {
        return "CD: " + this.getAuthor() + " | " + this.getTitle() + " [" + this.getFormat().format()+ "]";
    }
}
//Koniec, Tydzień 7, zasada otwarte - zamnkięte na abstrakcji 2