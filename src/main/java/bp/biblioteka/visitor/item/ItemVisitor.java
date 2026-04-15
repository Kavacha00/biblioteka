package bp.biblioteka.visitor.item;

import bp.biblioteka.composite.item.AuthorCollection;
import bp.biblioteka.decorator.Item.BestsellerDecorator;
import bp.biblioteka.entity.item.Item;

public interface ItemVisitor {
    String visitBook(Item book);
    String visitBestseller(BestsellerDecorator bestseller);
}
