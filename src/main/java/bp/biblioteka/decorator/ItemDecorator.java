package bp.biblioteka.decorator;

import bp.biblioteka.entity.item.Item;

//Tydzień 3, Wzorzec Decorator
//Możliwość dynamicznego dodania do itemu atrybutu "bestseller
public class ItemDecorator extends Item {
    protected Item item;

    public ItemDecorator(Item item) {
        super(item.getAuthor(), item.getTitle(),  item.getFormat());
        this.id = item.getId();
        this.item = item;
    }

    @Override
    public String describe() {
        return item.describe();
    }
}
