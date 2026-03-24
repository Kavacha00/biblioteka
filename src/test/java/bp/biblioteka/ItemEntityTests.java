package bp.biblioteka;

import bp.biblioteka.adapter.item.BookTranslateAdapter;
import bp.biblioteka.adapter.item.ItemTranslatorObjectAdapterImpl;
import bp.biblioteka.bridge.item.DigitalFormat;
import bp.biblioteka.bridge.item.ItemFormat;
import bp.biblioteka.bridge.item.PhysicalFormat;
import bp.biblioteka.composite.item.AuthorCollection;
import bp.biblioteka.decorator.Item.BestsellerDecorator;
import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.item.Item;
import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.Employee;
import bp.biblioteka.entity.user.User;
import bp.biblioteka.facade.item.ItemFacade;
import bp.biblioteka.proxy.item.SecuredItemProxy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemEntityTests {

//    @Test
//    public void testBookCreatorSingletonAndFactory() {
//        BookCreator factory1 = BookCreator.getInstance();
//        BookCreator factory2 = BookCreator.getInstance();
//
//        assertSame(factory1, factory2, "BookCreator powinien zwracać zawsze tę samą instancję (Singleton)!");
//
//        Item book = factory1.createItem("Andrzej Sapkowski", "Wiedźmin");
//
//        assertNotNull(book, "Fabryka nie powinna zwracać null");
//        assertTrue(book instanceof Book, "Fabryka powinna produkować obiekty typu Book");
//        assertEquals("Andrzej Sapkowski", book.getAuthor(), "Autor powinien się zgadzać");
//        assertEquals("Wiedźmin", book.getTitle(), "Tytuł powinien się zgadzać");
//    }
//
//    @Test
//    public void testBookBuilderAndReset() {
//        BookBuilder builder = new BookBuilder();
//
//        Book book1 = builder
//                .author("Frank Herbert")
//                .title("Diuna")
//                .build();
//
//        assertEquals("Diuna", book1.getTitle());
//        assertEquals("Frank Herbert", book1.getAuthor());
//
//        Book emptyBook = builder.build();
//        assertNull(emptyBook.getTitle(), "Po wywołaniu build(), builder powinien się zresetować (tytuł null)");
//        assertNull(emptyBook.getAuthor(), "Po wywołaniu build(), builder powinien się zresetować (autor null)");
//    }
//
//    @Test
//    public void testBookPrototypeClone() {
//        Book originalBook = new Book("J.R.R. Tolkien", "Hobbit");
//
//        Book clonedBook = originalBook.clone();
//
//        assertNotSame(originalBook, clonedBook, "Klon i oryginał to muszą być dwa różne obiekty w pamięci");
//
//        assertEquals(originalBook.getTitle(), clonedBook.getTitle(), "Tytuł musi zostać skopiowany");
//        assertEquals(originalBook.getAuthor(), clonedBook.getAuthor(), "Autor musi zostać skopiowany");
//
//        assertNotEquals(originalBook.getId(), clonedBook.getId(), "Sklonowana książka powinna otrzymać własne, unikalne ID");
//    }


    @Test
    public void testBridgePatternFormats() {
        ItemFormat physical = new PhysicalFormat();
        ItemFormat digital = new DigitalFormat();

        Item paperBook = new Book("Andrzej Sapkowski", "Wiedźmin", physical);
        Item eBook = new Book("J.R.R. Tolkien", "Hobbit", digital);

        assertFalse(paperBook.getFormat().isDownloadable(), "Fizyczna książka nie powinna być do pobrania");
        assertTrue(eBook.getFormat().isDownloadable(), "E-book powinien być do pobrania");

        assertTrue(paperBook.describe().contains("Format fizyczny"));
        assertTrue(eBook.describe().contains("Format elektroniczny"));
    }

    @Test
    public void testAdapterPatternTranslation() {
        ItemFormat physical = new PhysicalFormat();
        Item englishBook = new Book("J.R.R. Tolkien", "Lord of the Rings", physical);

        BookTranslateAdapter adapter = new ItemTranslatorObjectAdapterImpl(englishBook);

        String polishDesc = adapter.getPolishDescription();
        String germanDesc = adapter.getGermanDescription();

        assertTrue(polishDesc.contains("Książka:"), "Adapter powinien przetłumaczyć 'Book' na 'Książka'");
        assertTrue(germanDesc.contains("Buch:"), "Adapter powinien przetłumaczyć 'Book' na 'Buch'");

        assertTrue(polishDesc.contains("J.R.R. Tolkien"));
    }

    @Test
    public void testCompositePatternAuthorCollection() {
        ItemFormat digital = new DigitalFormat();
        Item book1 = new Book("Andrzej Sapkowski", "Ostatnie Życzenie", digital);
        Item book2 = new Book("Andrzej Sapkowski", "Krew Elfów", digital);
        Item alienBook = new Book("Frank Herbert", "Diuna", digital);

        AuthorCollection collection = new AuthorCollection("Andrzej Sapkowski");
        collection.addItem(book1);
        collection.addItem(book2);

        collection.addItem(alienBook);

        String collectionDescription = collection.describe();

        assertTrue(collectionDescription.contains("Ostatnie Życzenie"), "Kompozyt powinien zawierać pierwszą książkę");
        assertTrue(collectionDescription.contains("Krew Elfów"), "Kompozyt powinien zawierać drugą książkę");

        assertFalse(collectionDescription.contains("Diuna"), "Kompozyt nie powinien zawierać książki obcego autora");

        assertTrue(collectionDescription.contains("Różne formaty"), "Kompozyt powinien korzystać ze specjalnego formatu zbioru");
    }

    @Test
    public void testDecoratorPatternBestseller() {
        ItemFormat physical = new PhysicalFormat();
        Item normalBook = new Book("J.K. Rowling", "Harry Potter", physical);

        Item bestseller = new BestsellerDecorator(normalBook);

        assertTrue(bestseller.describe().contains("Harry Potter"));
        assertTrue(bestseller.describe().endsWith("Bestseller"), "Dekorator powinien dodać znaczek bestsellera na końcu opisu");

        assertEquals(normalBook.getId(), bestseller.getId(), "Udekorowany obiekt musi mieć to samo ID co oryginał");

        assertEquals(normalBook.getFormat(), bestseller.getFormat(), "Udekorowany obiekt musi zachować format oryginału");
    }



    @Test
    public void testFacadeCreatesObjectsCorrectly() {
        ItemFacade facade = new ItemFacade();

        Item physicalBook = facade.createPhysicalBook("Andrzej Sapkowski", "Wiedźmin");
        Item digitalBestseller = facade.createBestsellerBook("J.R.R. Tolkien", "Hobbit", true);

        assertEquals("Andrzej Sapkowski", physicalBook.getAuthor(), "Fasada powinna poprawnie ustawić autora");
        assertEquals("Wiedźmin", physicalBook.getTitle(), "Fasada powinna poprawnie ustawić tytuł");

        assertTrue(digitalBestseller.getFormat().isDownloadable(), "Bestseller stworzony jako 'digital' powinien być pobieralny");
    }

    @Test
    public void testProxyAccessControl() {
        ItemFacade facade = new ItemFacade();
        Item baseBook = facade.createPhysicalBook("Frank Herbert", "Diuna");

        User pracownik = new Employee("Anna Nowak", "anna@anna", "anna", "anna");
        User zwyklyKlient = new Customer("Jan Kowalski", "jan@jan",  "jan", "jan");

        Item proxyForEmployee = new SecuredItemProxy(baseBook, pracownik);
        Item proxyForCustomer = new SecuredItemProxy(baseBook, zwyklyKlient);

        String employeeDetails = proxyForEmployee.getInternalDetails();
        assertNotEquals("Odmowa dostępu", employeeDetails, "Pracownik powinien widzieć tajne dane");

        String customerDetails = proxyForCustomer.getInternalDetails();
        assertEquals("Odmowa dostępu", customerDetails, "Zwykły klient powinien dostać komunikat o odmowie dostępu");

        assertEquals(baseBook.describe(), proxyForCustomer.describe(), "Proxy nie powinno blokować metody describe()");
    }

    @Test
    public void testFlyweightSharesFormatInstances() {
        ItemFacade facade = new ItemFacade();

        Item book1 = facade.createPhysicalBook("Autor 1", "Tytuł 1");
        Item book2 = facade.createPhysicalBook("Autor 2", "Tytuł 2");
        Item book3 = facade.createPhysicalBook("Autor 3", "Tytuł 3");

        ItemFormat format1 = book1.getFormat();
        ItemFormat format2 = book2.getFormat();
        ItemFormat format3 = book3.getFormat();

        assertSame(format1, format2, "Książka 1 i Książka 2 powinny współdzielić dokładnie ten sam obiekt formatu fizycznego");
        assertSame(format2, format3, "Książka 2 i Książka 3 powinny współdzielić dokładnie ten sam obiekt formatu fizycznego");
    }
}