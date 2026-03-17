package bp.biblioteka.decorator;

import bp.biblioteka.entity.item.Item;

public class ItemDecorator extends Item {
    protected Item item;

    public ItemDecorator(Item item) {
        super(item.getAuthor(), item.getTitle());
        this.id = item.getId();
        this.item = item;
    }

    @Override
    public String describe() {
        return item.describe();
    }
}
