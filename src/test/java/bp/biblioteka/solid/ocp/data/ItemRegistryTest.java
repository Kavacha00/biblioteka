package bp.biblioteka.solid.ocp.data;

import bp.biblioteka.bridge.item.ItemFormat;
import bp.biblioteka.entity.item.CD;
import bp.biblioteka.entity.item.Item;
import bp.biblioteka.solid.ocp.ItemRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemRegistryTest {

    @BeforeEach
    void setup() {
        ItemRegistry.register("CD", (artist, title, format) -> new CD(artist, title, format));
    }

    @Test
    void shouldCreateItemUsingRegistry() {
        Item item = ItemRegistry.create("CD", "Artist", "Title", new ItemFormat() {
            @Override
            public String format() {
                return "DIGITAL";
            }

            @Override
            public boolean isDownloadable() {
                return false;
            }
        });

        assertInstanceOf(CD.class, item);
    }

    @Test
    void shouldCreateItemWithCorrectFields() {
        Item item = ItemRegistry.create("CD", "Artist", "Title", new ItemFormat() {
            @Override
            public String format() {
                return "VINYL";
            }

            @Override
            public boolean isDownloadable() {
                return false;
            }
        });

        assertEquals("Artist", item.getAuthor());
        assertEquals("Title", item.getTitle());
        assertEquals("VINYL", item.getFormat().format());
    }

    @Test
    void shouldThrowExceptionForUnknownType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ItemRegistry.create("UNKNOWN", "A", "B", null);
        });

        assertTrue(exception.getMessage().contains("Unknown type"));
    }
}