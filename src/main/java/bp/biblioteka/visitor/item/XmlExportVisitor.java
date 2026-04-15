package bp.biblioteka.visitor.item;

import bp.biblioteka.decorator.Item.BestsellerDecorator;
import bp.biblioteka.entity.item.Item;

public class XmlExportVisitor implements ItemVisitor {
    @Override
    public String visitBook(Item book){
        return "<book>\n" +
                "    <id>" + book.getId() + "</id>\n" +
                "    <author>" + book.getAuthor() + "</author>\n" +
                "    <title>" + book.getTitle() + "</title>\n" +
                "</book>";
    }

    @Override
    public String visitBestseller(BestsellerDecorator bestseller){
        return "<bestseller>\n" +
                "    <author>" + bestseller.getAuthor() + "</author>\n" +
                "    <title>" + bestseller.getTitle() + "</title>\n" +
                "    <badge>Bestseller</badge>\n" +
                "</bestseller>";
    }

}
//Koniec, Tydzień 6, Wzorzec Visitor 3