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
}