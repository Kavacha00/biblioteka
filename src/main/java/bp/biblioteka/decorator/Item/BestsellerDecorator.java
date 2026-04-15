package bp.biblioteka.decorator.Item;

import bp.biblioteka.entity.item.Item;
import bp.biblioteka.visitor.item.ItemVisitor;

public class BestsellerDecorator extends ItemDecorator {
    public BestsellerDecorator(Item item) {
        super(item);
    }

    @Override
    public String describe() {
        return item.describe() + " | Bestseller";
    }


    @Override
    public String accept(ItemVisitor visitor) {
        return visitor.visitBestseller(this);
    }
}
//Koniec, Tydzień 3, Wzorzec Decorator