package bp.biblioteka;

import bp.biblioteka.command.item.ChangeTitleCommand;
import bp.biblioteka.command.item.CommandInvoker;
import bp.biblioteka.command.item.ItemCommand;
import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.item.Item;
import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.User;
import bp.biblioteka.facade.item.ItemFacade;
import bp.biblioteka.interpreter.item.AndExpression;
import bp.biblioteka.interpreter.item.AuthorExpression;
import bp.biblioteka.interpreter.item.ItemExpression;
import bp.biblioteka.interpreter.item.TitleExpression;
import bp.biblioteka.iterator.item.ItemCollection;
import bp.biblioteka.iterator.item.ItemCollectionImpl;
import bp.biblioteka.iterator.item.ItemIterator;
import bp.biblioteka.mediator.LibraryMediator;
import bp.biblioteka.mediator.LibraryMediatorImpl;
import bp.biblioteka.memento.item.ItemHistory;
import bp.biblioteka.memento.item.ItemMemento;
import bp.biblioteka.strategy.item.HighPenalty;
import bp.biblioteka.template.item.DigitalBookProcessor;
import bp.biblioteka.template.item.ItemProcessingTemplate;
import bp.biblioteka.template.item.PhysicalBookProcessor;
import bp.biblioteka.visitor.item.ItemVisitor;
import bp.biblioteka.visitor.item.XmlExportVisitor;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BibliotekaApplication {



    public static void main(String[] args) {

        ItemFacade facade = new ItemFacade();
        List<Item> magazyn = new ArrayList<>();

        Item zwyklaKsiazka = facade.createPhysicalBook("Frank Herbert", "Diuna");
        magazyn.add(zwyklaKsiazka);

        Item hitSprzedazy = facade.createBestsellerBook("J.K. Rowling", "Harry Potter", false);
        magazyn.add(hitSprzedazy);

        ItemVisitor eksportXml = new XmlExportVisitor();

        System.out.println("Eksport bazy do pliku XML:\n");
        for (Item element : magazyn) {
            String xml = element.accept(eksportXml);
            System.out.println(xml);
            System.out.println("-------------------------");
        }

    }
}
