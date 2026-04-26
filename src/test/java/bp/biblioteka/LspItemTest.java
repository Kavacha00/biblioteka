package bp.biblioteka;

import bp.biblioteka.bridge.item.ItemFormat;
import bp.biblioteka.bridge.item.PhysicalFormat;
import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.item.CD;
import bp.biblioteka.entity.item.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LspItemTest {

    private void verifyItemBehavior(Item item) {
        String description = item.describe();
        String internalDetails = item.getInternalDetails();

        assertNotNull(description, "Metoda describe() nie powinna zwracać null.");
        assertTrue(description.contains(item.getTitle()), "Opis powinien zawierać tytuł przedmiotu.");

        assertNotNull(internalDetails, "Metoda getInternalDetails() nie powinna zwracać null.");
    }

    @Test
    void shouldProcessBookAsBaseItem() {
        ItemFormat format = new PhysicalFormat();
        Item book = new Book("J.R.R. Tolkien", "Władca Pierścieni", format);

        verifyItemBehavior(book);
    }

    @Test
    void shouldProcessCdAsBaseItem() {
        ItemFormat format = new PhysicalFormat();
        Item cd = new CD("Pink Floyd", "The Dark Side of the Moon", format);

        verifyItemBehavior(cd);
    }
}
