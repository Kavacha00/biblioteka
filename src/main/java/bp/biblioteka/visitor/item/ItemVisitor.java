package bp.biblioteka.visitor.item;

import bp.biblioteka.composite.item.AuthorCollection;
import bp.biblioteka.decorator.Item.BestsellerDecorator;
import bp.biblioteka.entity.item.Item;

//Tydzień 6, Wzorzec Visitor 3
//Tworzenie raportu o przedmiotach w formacie XML
public interface ItemVisitor {
    String visitBook(Item book);
    String visitBestseller(BestsellerDecorator bestseller);
}
