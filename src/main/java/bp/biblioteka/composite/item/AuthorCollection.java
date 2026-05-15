package bp.biblioteka.composite.item;

import bp.biblioteka.bridge.item.CollectionFormat;
import bp.biblioteka.entity.item.Item;
import bp.biblioteka.visitor.item.ItemVisitor;

import java.util.ArrayList;
import java.util.List;

//Tydzień 3, Wzorzec Composite
//Możliwość zgrupowania wszystkich dzieł autora
public class AuthorCollection extends Item {
    private List<Item> items = new ArrayList<Item>();

    public AuthorCollection(String author) {
        super(author, "Kolekcja autora", new CollectionFormat());
    }

    public void addItem(Item item){
        if(item.getAuthor().equals(this.getAuthor()))
            items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    @Override
    public String describe() {
        StringBuilder sb = new StringBuilder();
        sb.append("Autor: ").append(getAuthor()).append(" [").append(this.getFormat().format()).append("]\n");
        for(Item item : items){
            sb.append(item.getTitle()).append("\n");
        }
        return sb.toString();
    }
}
//Koniec, Tydzień 3, Wzorzec Composite