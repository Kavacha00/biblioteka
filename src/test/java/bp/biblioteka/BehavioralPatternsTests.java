package bp.biblioteka;

import bp.biblioteka.command.item.ChangeTitleCommand;
import bp.biblioteka.command.item.CommandInvoker;
import bp.biblioteka.command.item.ItemCommand;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BehavioralPatternsTests {
    private ItemFacade facade;

    @BeforeEach
    public void setUp() {
        facade = new ItemFacade();
    }

    @Test
    public void testIteratorFiltersByAuthorAndResets() {
        ItemCollection collection = new ItemCollectionImpl();
        collection.addItem(facade.createPhysicalBook("Andrzej Sapkowski", "Wiedźmin"));
        collection.addItem(facade.createPhysicalBook("J.R.R. Tolkien", "Hobbit"));
        collection.addItem(facade.createDigitalBook("Andrzej Sapkowski", "Narrenturm"));

        ItemIterator iterator = collection.itemAuthorIterator("Andrzej Sapkowski");

        assertTrue(iterator.hasNext());
        assertEquals("Wiedźmin", iterator.next().getTitle());

        assertTrue(iterator.hasNext());
        assertEquals("Narrenturm", iterator.next().getTitle());

        assertFalse(iterator.hasNext());

        iterator.reset();
        assertTrue(iterator.hasNext());
        assertEquals("Wiedźmin", iterator.next().getTitle(), "Po resecie iterator powinien znowu wskazywać na pierwszą książkę");
    }

    @Test
    public void testCommandExecutesAndUndoesAction() {
        Item book = facade.createPhysicalBook("Frank Herbert", "Diuna");
        CommandInvoker invoker = new CommandInvoker();

        ItemCommand changeTitleCmd = new ChangeTitleCommand(book, "Dune Messiah");

        invoker.execute(changeTitleCmd);
        assertEquals("Dune Messiah", book.getTitle(), "Tytuł powinien zostać zmieniony przez polecenie");
    }

    @Test
    public void testMementoSavesAndRestoresState() {
        Item book = facade.createPhysicalBook("J.K. Rowling", "Harry Potter");
        ItemHistory history = new ItemHistory();

        history.backup(book.saveStateToMemento());

        book.setTitle("Hary Poter");
        history.backup(book.saveStateToMemento());

        book.setTitle("Garri Patter");

        ItemMemento snapshot2 = history.undo();
        assertNotNull(snapshot2);
        book.restoreStateFromMemento(snapshot2);
        assertEquals("Hary Poter", book.getTitle(), "Powinien przywrócić pierwszy zepsuty stan");

        ItemMemento snapshot1 = history.undo();
        assertNotNull(snapshot1);
        book.restoreStateFromMemento(snapshot1);
        assertEquals("Harry Potter", book.getTitle(), "Powinien przywrócić oryginalny stan");
    }

    @Test
    public void testMediatorHandlesBorrowingLogic() {
        LibraryMediator mediator = new LibraryMediatorImpl();
        Item book = facade.createPhysicalBook("Bolesław Prus", "Lalka");

        User user1 = new Customer("Jan Kowalski","","","");
        User user2 = new Customer("Anna Nowak", "","","");

//        assertFalse(book.isBorrowed(), "Książka domyślnie nie powinna być wypożyczona");
//
//        mediator.borrowItem(user1, book);
//        assertTrue(book.isBorrowed(), "Po wypożyczeniu status książki to true");
//
//        mediator.borrowItem(user2, book);
//        assertTrue(book.isBorrowed(), "Nieudane wypożyczenie nie powinno zmieniać statusu");
//
//        mediator.returnItem(user1, book);
//        assertFalse(book.isBorrowed(), "Po zwrocie książka jest znów dostępna (false)");
    }

    @Test
    public void testInterpreterEvaluatesExpressions() {
        Item book = facade.createPhysicalBook("Andrzej Sapkowski", "Wiedźmin: Krew Elfów");

        ItemExpression isSapkowski = new AuthorExpression("sapkowski");
        ItemExpression isTolkien = new AuthorExpression("tolkien");
        ItemExpression hasWiedzmin = new TitleExpression("wiedźmin");

        assertTrue(isSapkowski.interpret(book), "Wyrażenie powinno rozpoznać autora niezależnie od wielkości liter");
        assertFalse(isTolkien.interpret(book), "Wyrażenie powinno odrzucić błędnego autora");

        ItemExpression andExpressionTrue = new AndExpression(isSapkowski, hasWiedzmin);
        assertTrue(andExpressionTrue.interpret(book), "Książka powinna spełniać oba poprawne warunki");

        ItemExpression andExpressionFalse = new AndExpression(isTolkien, hasWiedzmin);
        assertFalse(andExpressionFalse.interpret(book), "Książka nie powinna spełniać warunku, jeśli jeden człon jest fałszywy");
    }
}