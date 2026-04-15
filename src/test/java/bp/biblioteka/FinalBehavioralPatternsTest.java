package bp.biblioteka;

import bp.biblioteka.decorator.Item.BestsellerDecorator;
import bp.biblioteka.entity.item.Item;
import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.facade.item.ItemFacade;
import bp.biblioteka.mediator.LibraryMediator;
import bp.biblioteka.mediator.LibraryMediatorImpl;
import bp.biblioteka.strategy.item.HighPenalty;
import bp.biblioteka.strategy.item.StandardPenalty;
import bp.biblioteka.template.item.DigitalBookProcessor;
import bp.biblioteka.template.item.ItemProcessingTemplate;
import bp.biblioteka.template.item.PhysicalBookProcessor;
import bp.biblioteka.visitor.item.ItemVisitor;
import bp.biblioteka.visitor.item.XmlExportVisitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FinalBehavioralPatternsTest {
    private ItemFacade facade;

    @BeforeEach
    public void setUp() {
        facade = new ItemFacade();
    }

    @Test
    public void testStateTransitions() {
        Item book = facade.createPhysicalBook("Frank Herbert", "Diuna");

        assertEquals("Dostępny", book.getItemState().getStateName(), "Nowa książka powinna być dostępna");

        boolean borrowResult = book.getItemState().borrowItem(book);
        assertTrue(borrowResult, "Wypożyczenie dostępnej książki powinno się udać");
        assertEquals("Wypożyczony", book.getItemState().getStateName(), "Stan po wypożyczeniu to 'Wypożyczona'");

        boolean borrowAgain = book.getItemState().borrowItem(book);
        assertFalse(borrowAgain, "Nie można wypożyczyć książki, która jest już wypożyczona");
    }

    @Test
    public void testObserverNotificationProcess() {
        Item book = facade.createPhysicalBook("J.R.R. Tolkien", "Hobbit");
        LibraryMediator mediator = new LibraryMediatorImpl();

        Customer jan = new Customer("Jan Kow", "jan@test.pl", "jkow", "pass1");
        Customer anna = new Customer("Anna Now", "anna@test.pl", "anow", "pass2");

        mediator.borrowItem(jan, book);
        book.addObserver(anna);

        mediator.returnItem(jan, book);

        assertEquals("Dostępny", book.getItemState().getStateName());
    }

    @Test
    public void testPenaltyStrategyCalculations() {
        Item book = facade.createPhysicalBook("Henryk Sienkiewicz", "Potop");
        int delayDays = 5;

        book.setPenaltyStrategy(new StandardPenalty());
        assertEquals(10.0, book.calculatePenalty(delayDays), 0.01, "Błąd w obliczeniach dla StandardPenalty");

        book.setPenaltyStrategy(new HighPenalty());
        assertEquals(35.0, book.calculatePenalty(delayDays), 0.01, "Błąd w obliczeniach dla HighPenalty");
    }

    @Test
    public void testTemplateMethodExecution() {
        Item physicalBook = facade.createPhysicalBook("Andrzej Sapkowski", "Wiedźmin");
        Item digitalBook = facade.createDigitalBook("J.K. Rowling", "Harry Potter");

        ItemProcessingTemplate physicalProcessor = new PhysicalBookProcessor();
        ItemProcessingTemplate digitalProcessor = new DigitalBookProcessor();

        assertDoesNotThrow(() -> physicalProcessor.processNewItem(physicalBook), "Procesowanie książki fizycznej rzuciło wyjątek");
        assertDoesNotThrow(() -> digitalProcessor.processNewItem(digitalBook), "Procesowanie książki cyfrowej rzuciło wyjątek");
    }

    @Test
    public void testVisitorXmlExport() {
        ItemVisitor exportVisitor = new XmlExportVisitor();

        Item standardBook = facade.createPhysicalBook("Stanisław Lem", "Solaris");
        BestsellerDecorator bestseller = (BestsellerDecorator) facade.createBestsellerBook("George R.R. Martin", "Gra o Tron", false);

        String xmlStandard = standardBook.accept(exportVisitor);
        String xmlBestseller = bestseller.accept(exportVisitor);

        assertTrue(xmlStandard.contains("<book>"), "Zwykła książka powinna zawierać tag <book>");
        assertTrue(xmlStandard.contains("Stanisław Lem"), "Brakuje autora w eksporcie XML");

        assertTrue(xmlBestseller.contains("<bestseller>"), "Bestseller powinien zawierać tag <bestseller>");
        assertTrue(xmlBestseller.contains("Bestseller"), "Brakuje specjalnego znacznika w Bestsellerze");
    }
}
