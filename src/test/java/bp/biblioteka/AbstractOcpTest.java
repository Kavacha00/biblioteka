package bp.biblioteka;

import bp.biblioteka.bridge.item.ItemFormat;
import bp.biblioteka.entity.item.CD;
import bp.biblioteka.entity.item.Item;
import bp.biblioteka.factory.item.CDCreator;
import bp.biblioteka.strategy.item.HighPenalty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractOcpTest {
    private final ItemFormat dummyFormat = new ItemFormat() {
        @Override
        public String format() {
            return "physical";
        }

        @Override
        public boolean isDownloadable() {
            return false;
        }
    };

    @Test
    public void testCdCreationAndDescription() {
        CD cd = new CD("Nirvana", "Nevermind", dummyFormat);

        assertEquals("Nirvana", cd.getAuthor(), "Pole artist powinno zostać zapisane jako author w klasie bazowej");
        assertEquals("Nevermind", cd.getTitle());

        String expectedDescription = "CD: Nirvana | Nevermind [physical]";
        assertEquals(expectedDescription, cd.describe(), "Metoda describe() w CD zwraca zły format tekstu");
    }

    @Test
    public void testCdCreatorCreatesCorrectItemAndIsSingleton() {
        CDCreator creator1 = CDCreator.getInstance();
        CDCreator creator2 = CDCreator.getInstance();
        assertSame(creator1, creator2, "CDCreator powinien zwracać tę samą instancję (Singleton)");

        Item item = creator1.createItem("Pink Floyd", "The Wall", dummyFormat);

        assertNotNull(item, "Fabryka nie powinna zwracać null");
        assertTrue(item instanceof CD, "Obiekt stworzony przez CDCreator powinien być instancją klasy CD");
        assertEquals("Pink Floyd", item.getAuthor());
    }

    @Test
    public void testHighPenaltyCalculation() {
        HighPenalty penalty = new HighPenalty();

        assertEquals(10.0, penalty.calculatePenalty(0), 0.001);

        assertEquals(15.0, penalty.calculatePenalty(1), 0.001);

        assertEquals(35.0, penalty.calculatePenalty(5), 0.001);
    }
}
