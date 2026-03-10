package bp.biblioteka;

import bp.biblioteka.builder.item.BookBuilder;
import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.item.Item;
import bp.biblioteka.factory.item.BookCreator;
import org.junit.jupiter.api.Test;

// Importujemy statyczne metody asercji z JUnit 5
import static org.junit.jupiter.api.Assertions.*;

public class DesignPatternsTest {

    //test singleton i factory method
    @Test
    public void testBookCreatorSingletonAndFactory() {
        BookCreator factory1 = BookCreator.getInstance();
        BookCreator factory2 = BookCreator.getInstance();

        assertSame(factory1, factory2, "BookCreator powinien zwracać zawsze tę samą instancję (Singleton)!");

        Item book = factory1.createItem("Andrzej Sapkowski", "Wiedźmin");

        assertNotNull(book, "Fabryka nie powinna zwracać null");
        assertTrue(book instanceof Book, "Fabryka powinna produkować obiekty typu Book");
        assertEquals("Andrzej Sapkowski", book.getAuthor(), "Autor powinien się zgadzać");
        assertEquals("Wiedźmin", book.getTitle(), "Tytuł powinien się zgadzać");
    }

    //test builder
    @Test
    public void testBookBuilderAndReset() {
        BookBuilder builder = new BookBuilder();

        Book book1 = builder
                .author("Frank Herbert")
                .title("Diuna")
                .build();

        assertEquals("Diuna", book1.getTitle());
        assertEquals("Frank Herbert", book1.getAuthor());

        Book emptyBook = builder.build();
        assertNull(emptyBook.getTitle(), "Po wywołaniu build(), builder powinien się zresetować (tytuł null)");
        assertNull(emptyBook.getAuthor(), "Po wywołaniu build(), builder powinien się zresetować (autor null)");
    }

    //test prototype
    @Test
    public void testBookPrototypeClone() {
        Book originalBook = new Book("J.R.R. Tolkien", "Hobbit");

        Book clonedBook = originalBook.clone();

        assertNotSame(originalBook, clonedBook, "Klon i oryginał to muszą być dwa różne obiekty w pamięci");

        assertEquals(originalBook.getTitle(), clonedBook.getTitle(), "Tytuł musi zostać skopiowany");
        assertEquals(originalBook.getAuthor(), clonedBook.getAuthor(), "Autor musi zostać skopiowany");

        assertNotEquals(originalBook.getId(), clonedBook.getId(), "Sklonowana książka powinna otrzymać własne, unikalne ID");
    }
}