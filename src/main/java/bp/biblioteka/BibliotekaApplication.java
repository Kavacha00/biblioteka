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
//        SpringApplication.run(BibliotekaApplication.class, args);

        //builder
//        BookBuilder bookBuilder = new BookBuilder();
//        Book myBook = bookBuilder
//                .title("Wiedźmin: Ostatnie życzenie")
//                .author("Andrzej Sapkowski")
//                .build();
//
//        Book myBook1 = bookBuilder
//                .build();
//
//        System.out.println(myBook.describe());
//        System.out.println(myBook1.describe());

        //prototype
//        BookBuilder builder = new BookBuilder();
//
//        Book originalBook = builder
//                .author("Frank Herbert")
//                .title("Diuna")
//                .build();
//
//        Book clonedBook = originalBook.clone();
//
//        System.out.println("Oryginał: " + originalBook.describe() + " | ID: " + originalBook.getId());
//        System.out.println("Klon: " + clonedBook.describe() + " | ID: " + clonedBook.getId());

//        BookCreator factory1 = BookCreator.getInstance();
//
//        BookCreator factory2 = BookCreator.getInstance();
//
//        System.out.println("Czy factory1 i factory2 to ten sam obiekt? " + (factory1 == factory2));
//
//        Item book1 = factory1.createItem("Andrzej Sapkowski", "Wiedźmin");
//        Item book2 = factory1.createItem("J.R.R. Tolkien", "Hobbit");
//
//        System.out.println(book1.describe());
//        System.out.println(book2.describe());


//        Item book = new Book("Pan Autor", "Abababa");
//        System.out.println(book.describe());
//
//        BookTranslateAdapter translateAdapter = new ItemTranslatorObjectAdapterImpl(book);
//
//        System.out.println(translateAdapter.getPolishDescription());
//        System.out.println(translateAdapter.getGermanDescription());

//        Item book1 = new Book("Andrzej Sapkowski", "Ostatnie Życzenie");
//        Item book2 = new Book("Andrzej Sapkowski", "Miecz Przeznaczenia");
//        Item book3 = new Book("Andrzej Sapkowski", "Krew Elfów");
//
//        Item book4 = new Book("Frank Herbert", "Diuna");
//
//        AuthorCollection sapkowskiCollection = new AuthorCollection("Andrzej Sapkowski");
//
//        sapkowskiCollection.addItem(book1);
//        sapkowskiCollection.addItem(book2);
//        sapkowskiCollection.addItem(book3);
//
//        sapkowskiCollection.addItem(book4);
//
//        System.out.println(sapkowskiCollection.describe());


//        Item normalBook = new Book("J.K. Rowling", "Harry Potter i Kamień Filozoficzny");
//        System.out.println(normalBook.describe());
//
//        Item hitBook = new BestsellerDecorator(normalBook);
//        System.out.println(hitBook.describe());

//        ItemFormat physical = new PhysicalFormat();
//        ItemFormat digital = new DigitalFormat();
//
//        Item paperBook = new Book("Andrzej Sapkowski", "Wiedźmin", physical);
//        Item eBook = new Book("J.R.R. Tolkien", "Hobbit", digital);
//
//        System.out.println(paperBook.describe());
//        System.out.println("Czy można pobrać? " + paperBook.getFormat().isDownloadable());
//
//        System.out.println("\n" + eBook.describe());
//        System.out.println("Czy można pobrać? " + eBook.getFormat().isDownloadable());


//        ItemFacade itemFacade = new ItemFacade();
//        Item standardBook = itemFacade.createPhysicalBook("Janusz", "Jak uprawiać buraki");
//        Item hitBook = itemFacade.createBestsellerBook("Andrzej", "Piwo kontra wódka", false);
//
//        AuthorCollection collection = itemFacade.createAuthorCollection("Andrzej");
//        collection.addItem(hitBook);
//
//        System.out.println(standardBook.describe());
//        System.out.println(collection.describe());


//        User customer = new Customer("A", "a", "a", "a");
//        User employee = new Employee("B", "b", "b", "b");
//
//        Item book = new Book("C", "C", new PhysicalFormat());
//        SecuredItemProxy securedBook = new SecuredItemProxy(book, employee);
//        System.out.println(securedBook.describe());
//
//        System.out.println(securedBook.getInternalDetails());


//        ItemFacade facade = new ItemFacade();
//        Item book1 = facade.createPhysicalBook("A", "B");
//        Item book2 = facade.createPhysicalBook("C", "D");
//
//        System.out.println(book1.getFormat() == book2.getFormat());


//        ItemFacade facade = new ItemFacade();
//
//        ItemCollection biblioteczka = new ItemCollectionImpl();
//
//        biblioteczka.addItem(facade.createPhysicalBook("Andrzej Sapkowski", "Ostatnie Życzenie"));
//        biblioteczka.addItem(facade.createDigitalBook("J.R.R. Tolkien", "Hobbit"));
//        biblioteczka.addItem(facade.createPhysicalBook("Andrzej Sapkowski", "Krew Elfów"));
//        biblioteczka.addItem(facade.createBestsellerBook("Frank Herbert", "Diuna", false));
//        biblioteczka.addItem(facade.createDigitalBook("Andrzej Sapkowski", "Wieża Jaskółki"));
//
//        String szukanyAutor = "Andrzej Sapkowski";
//        ItemIterator sapkowskiIterator = biblioteczka.itemAuthorIterator(szukanyAutor);
//
//        System.out.println("\nZnalezione książki autora: " + szukanyAutor);
//
//        while (sapkowskiIterator.hasNext()) {
//            Item znalezionaKsiazka = sapkowskiIterator.next();
//            System.out.println(" - " + znalezionaKsiazka.getTitle() + " [" + znalezionaKsiazka.getFormat().format() + "]");
//        }
//
//        sapkowskiIterator.reset();
//
//        if (sapkowskiIterator.hasNext()) {
//            System.out.println("Po resecie pierwsza książka to znowu: " + sapkowskiIterator.next().getTitle());
//        }


//        ItemFacade facade = new ItemFacade();
//        CommandInvoker invoker = new CommandInvoker();
//
//        Item book = facade.createPhysicalBook("Andrzej Sapkowski", "Wiedźmin");
//        System.out.println("Początkowa książka: " + book.getTitle());
//
//        ItemCommand mistypedCommand = new ChangeTitleCommand(book, "Wiedźmi");
//
//        invoker.execute(mistypedCommand);
//        System.out.println("Po zmianie: " + book.getTitle());


//        ItemFacade facade = new ItemFacade();
//        ItemHistory opiekunHistorii = new ItemHistory();
//
//        Item book = facade.createPhysicalBook("Andrzej Sapkowski", "Wiedźmin");
//
//        opiekunHistorii.backup(book.saveStateToMemento());
//
//        book.setTitle("Wiedźmi - błąd w druku");
//        System.out.println("Stan po błędzie: " + book.getTitle());
//
//        opiekunHistorii.backup(book.saveStateToMemento());
//        book.setTitle("Wiedxmak");
//        System.out.println("Stan po drugim błędzie: " + book.getTitle());
//
//
//        ItemMemento ostatniStan = opiekunHistorii.undo();
//        if (ostatniStan != null) book.restoreStateFromMemento(ostatniStan);
//        System.out.println("Obecny tytuł: " + book.getTitle());
//
//        ItemMemento oryginalnyStan = opiekunHistorii.undo();
//        if (oryginalnyStan != null) book.restoreStateFromMemento(oryginalnyStan);
//        System.out.println("Obecny tytuł: " + book.getTitle());



//        ItemFacade facade = new ItemFacade();
//        LibraryMediator mediator = new LibraryMediatorImpl();
//
//        Item book = facade.createPhysicalBook("Andrzej Sapkowski", "Wiedźmin");
//        User user1 = new Customer("Jan Kowalski", "", "", "");
//        User user2 = new Customer("Anna Nowak", "", "", "");
//
//        System.out.println("Stan początkowy. Czy wypożyczona? " + book.isBorrowed());
//        System.out.println("--------------------------------------------------");
//
//        System.out.println("Akcja: Jan wypożycza książkę.");
//        mediator.borrowItem(user1, book);
//        System.out.println("Czy wypożyczona? " + book.isBorrowed());
//        System.out.println("--------------------------------------------------");
//
//        System.out.println("Akcja: Anna próbuje wypożyczyć tę samą książkę.");
//        mediator.borrowItem(user2, book);
//        System.out.println("Czy wypożyczona? " + book.isBorrowed());
//        System.out.println("--------------------------------------------------");
//
//       System.out.println("Akcja: Jan zwraca książkę.");
//        mediator.returnItem(user1, book);
//        System.out.println("Czy wypożyczona? " + book.isBorrowed());
//        System.out.println("--------------------------------------------------");
//
//        System.out.println("Akcja: Anna próbuje zwrócić książkę.");
//        mediator.returnItem(user2, book);
//        System.out.println("Czy wypożyczona? " + book.isBorrowed());


//        ItemFacade facade = new ItemFacade();
//        List<Item> library = new ArrayList<>();
//
//        library.add(facade.createPhysicalBook("Andrzej Sapkowski", "Wiedźmin: Krew Elfów"));
//        library.add(facade.createPhysicalBook("Andrzej Sapkowski", "Ostatnie Życzenie"));
//        library.add(facade.createPhysicalBook("J.R.R. Tolkien", "Władca Pierścieni"));
//        library.add(facade.createDigitalBook("Henryk Sienkiewicz", "Ogniem i Mieczem"));
//
//        ItemExpression isSapkowski = new AuthorExpression("sapkowski");
//        ItemExpression isWiedzmin = new TitleExpression("wiedźmin");
//
//        ItemExpression strictSearch = new AndExpression(isSapkowski, isWiedzmin);
//
//        System.out.println("Wyniki wyszukiwania (Autor: Sapkowski AND Tytuł: Wiedźmin):");
//
//        for (Item item : library) {
//            if (strictSearch.interpret(item)) {
//                System.out.println("Znaleziono: " + item.getAuthor() + " - " + item.getTitle());
//            } else {
//                System.out.println("Odrzucono: " + item.getAuthor() + " - " + item.getTitle());
//            }
//        }



//        ItemFacade facade = new ItemFacade();
//        LibraryMediator mediator = new LibraryMediatorImpl();
//
//        Item book = facade.createPhysicalBook("Andrzej Sapkowski", "Wiedźmin");
//
//        User jan = new Customer("Jan Kowalski", "", "", "");
//        User anna = new Customer("Anna Nowak", "", "", "");
//
//        System.out.println("Stan początkowy: [" + book.getItemState().getStateName() + "]");
//
//        System.out.println("Akcja: Jan chce wypożyczyć książkę.");
//        mediator.borrowItem(jan, book);
//        System.out.println("Aktualny stan: [" + book.getItemState().getStateName() + "]");
//
//        System.out.println("Akcja: Anna chce wypożyczyć książkę.");
//        mediator.borrowItem(anna, book);
//        System.out.println("Aktualny stan: [" + book.getItemState().getStateName() + "]");
//        System.out.println("--------------------------------------------------");
//
//        System.out.println("Akcja: Jan zwraca książkę.");
//        mediator.returnItem(jan, book);
//        System.out.println("Aktualny stan: [" + book.getItemState().getStateName() + "]");
//        System.out.println("--------------------------------------------------");
//
//        System.out.println("Akcja: Anna chce zwrócić książkę.");
//        mediator.returnItem(anna, book);
//        System.out.println("Aktualny stan: [" + book.getItemState().getStateName() + "]");


//        ItemFacade facade = new ItemFacade();
//        LibraryMediator mediator = new LibraryMediatorImpl();
//
//        Item book = facade.createPhysicalBook("Frank Herbert", "Diuna");
//
//        Customer jan = new Customer("Jan Kowalski", "", "", "");
//        Customer anna = new Customer("Anna Nowak", "", "", "");
//        Customer piotr = new Customer("Piotr Wiśniewski", "", "", "");
//
//        System.out.println("1. Jan wypożycza 'Diunę'.");
//        mediator.borrowItem(jan, book);
//
//        System.out.println("\n2. Anna i Piotr przychodzą do biblioteki, ale książki nie ma.");
//        System.out.println("Zapisują się na listę powiadomień.");
//
//        book.addObserver(anna);
//        book.addObserver(piotr);
//
//        System.out.println("\n3. Janzwraca książkę do biblioteki!");
//        mediator.returnItem(jan, book);


//        ItemFacade facade = new ItemFacade();
//        int days = 4;
//
//        Item standardBook = facade.createPhysicalBook("Henryk Sienkiewicz", "Potop");
//        System.out.println("Zwykła książka - kara: " + standardBook.calculatePenalty(days) + " PLN");
//
//        Item bestseller = facade.createPhysicalBook("Andrzej Sapkowski", "Wiedźmin");
//        bestseller.setPenaltyStrategy(new HighPenalty());
//        System.out.println("Bestseller - kara: " + bestseller.calculatePenalty(days) + " PLN");



//        ItemFacade facade = new ItemFacade();
//
//        Item papierowa = facade.createPhysicalBook("Frank Herbert", "Diuna");
//        Item cyfrowa = facade.createDigitalBook("J.R.R. Tolkien", "Hobbit (Audiobook)");
//
//        ItemProcessingTemplate procesorFizyczny = new PhysicalBookProcessor();
//        ItemProcessingTemplate procesorCyfrowy = new DigitalBookProcessor();
//
//        procesorFizyczny.processNewItem(papierowa);
//
//        procesorCyfrowy.processNewItem(cyfrowa);



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
