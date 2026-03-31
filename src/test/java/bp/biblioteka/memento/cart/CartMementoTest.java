package bp.biblioteka.memento.cart;

import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.item.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartMementoTest {

    @Test
    void shouldAddItemsToCart() {
        Cart cart = new Cart();
        Item item1 = new Book("John", "Title1", null);
        Item item2 = new Book("Doe", "Title2", null);

        cart.addItem(item1);
        cart.addItem(item2);

        CartMemento snapshot = cart.save();
        assertEquals(2, snapshot.getItems().size());
        assertTrue(snapshot.getItems().contains(item1));
        assertTrue(snapshot.getItems().contains(item2));
    }

    @Test
    void shouldRemoveItemFromCart() {
        Cart cart = new Cart();
        Item item1 = new Book("John", "Title1", null);
        Item item2 = new Book("Doe", "Title2", null);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.removeItem(item2);

        CartMemento snapshot = cart.save();
        assertEquals(1, snapshot.getItems().size());
        assertFalse(snapshot.getItems().contains(item2));
    }

    @Test
    void shouldRestorePreviousState() {
        Cart cart = new Cart();
        Item item1 = new Book("John", "Title1", null);
        Item item2 = new Book("Doe", "Title2", null);


        cart.addItem(item1);
        CartMemento saved = cart.save();

        cart.addItem(item2);
        cart.restore(saved);

        CartMemento afterRestore = cart.save();
        assertEquals(1, afterRestore.getItems().size());
        assertTrue(afterRestore.getItems().contains(item1));
        assertFalse(afterRestore.getItems().contains(item2));
    }

    @Test
    void shouldSupportUndoUsingHistory() {
        Cart cart = new Cart();
        CartHistory history = new CartHistory();
        Item item1 = new Book("John", "Title1", null);
        Item item2 = new Book("Doe", "Title2", null);
        Item item3 = new Book("John", "Title3", null);


        cart.addItem(item1);
        history.save(cart.save());

        cart.addItem(item2);
        history.save(cart.save());

        cart.addItem(item3);

        // undo 1
        cart.restore(history.undo());
        assertEquals(2, cart.save().getItems().size());

        // undo 2
        cart.restore(history.undo());
        assertEquals(1, cart.save().getItems().size());
    }

    @Test
    void undoOnEmptyHistoryShouldReturnNull() {
        CartHistory history = new CartHistory();

        CartMemento result = history.undo();

        assertNull(result);
    }

    @Test
    void mementoShouldBeImmutable() {
        Cart cart = new Cart();
        Item item1 = new Book("John", "Title1", null);
        Item item2 = new Book("Doe", "Title2", null);

        cart.addItem(item1);

        CartMemento snapshot = cart.save();

        snapshot.getItems().add(item2);

        CartMemento newSnapshot = cart.save();
        assertEquals(1, newSnapshot.getItems().size());
        assertFalse(newSnapshot.getItems().contains(item2));
    }

    @Test
    void restoringShouldNotShareReferences() {
        Cart cart = new Cart();
        Item item1 = new Book("John", "Title1", null);
        Item item2 = new Book("Doe", "Title2", null);

        cart.addItem(item1);

        CartMemento saved = cart.save();
        cart.restore(saved);


        cart.addItem(item2);

        assertEquals(1, saved.getItems().size());
        assertFalse(saved.getItems().contains(item2));
    }

}
