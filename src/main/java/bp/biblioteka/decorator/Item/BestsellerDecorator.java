package bp.biblioteka.decorator.Item;

import bp.biblioteka.entity.item.Item;

public class BestsellerDecorator extends ItemDecorator {
    public BestsellerDecorator(Item item) {
        super(item);
    }

    @Override
    public String describe() {
        return item.describe() + " | Bestseller";
    }
}
//Koniec, Tydzień 3, Wzorzec Decorator