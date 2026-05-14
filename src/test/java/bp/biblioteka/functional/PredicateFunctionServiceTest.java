package bp.biblioteka.functional;

import bp.biblioteka.bridge.item.DigitalFormat;
import bp.biblioteka.bridge.item.PhysicalFormat;
import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.item.CD;
import bp.biblioteka.entity.item.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PredicateFunctionServiceTest {

    private PredicateFunctionService service;

    private List<Item> items;

    @BeforeEach
    void setUp() {
        service = new PredicateFunctionService();

        items = List.of(
                new Book("Frank Herbert",  "Diuna",             new PhysicalFormat()),
                new Book("J.R.R. Tolkien", "Władca Pierścieni", new PhysicalFormat()),
                new Book("Isaac Asimov",   "Fundacja",          new DigitalFormat()),
                new CD("Miles Davis",      "Kind of Blue",      new DigitalFormat()),
                new CD("The Beatles",      "Abbey Road",        new PhysicalFormat())
        );
    }

    @Test
    void shouldReturnOnlyDigitalBooks() {
        var result = service.getDigitalBooks(items);

        assertEquals(1, result.size());
    }

    @Test
    void shouldReturnOnlyBookInstancesFromDigitalBooks() {
        var result = service.getDigitalBooks(items);

        result.forEach(item -> assertInstanceOf(Book.class, item));
    }

    @Test
    void shouldReturnOnlyDownloadableFormatItemsFromDigitalBooks() {
        var result = service.getDigitalBooks(items);

        result.forEach(item -> assertInstanceOf(DigitalFormat.class, item.getFormat()));
    }

    @Test
    void shouldReturnEmptyListWhenNoDigitalBooksPresent() {
        var paperOnly = List.<Item>of(
                new Book("Author", "Title", new PhysicalFormat()),
                new CD("Artist",   "Album", new PhysicalFormat())
        );

        var result = service.getDigitalBooks(paperOnly);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnOnlyNonBookItems() {
        var result = service.getNonBooks(items);

        result.forEach(item -> assertFalse(item instanceof Book));
    }

    @Test
    void shouldReturnCorrectCountOfNonBooks() {
        var result = service.getNonBooks(items);

        assertEquals(2, result.size());
    }

    @Test
    void shouldReturnEmptyListWhenAllItemsAreBooks() {
        var booksOnly = List.<Item>of(
                new Book("A", "T1", new PhysicalFormat()),
                new Book("B", "T2", new DigitalFormat())
        );

        var result = service.getNonBooks(booksOnly);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnOneReportLinePerItem() {
        var result = service.toReportLines(items);

        assertEquals(items.size(), result.size());
    }

    @Test
    void shouldReturnReportLineContainingTitle() {
        var result = service.toReportLines(List.of(items.get(0)));

        assertTrue(result.get(0).contains(items.get(0).getTitle()));
    }

    @Test
    void shouldReturnReportLineContainingAuthor() {
        var result = service.toReportLines(List.of(items.get(0)));

        assertTrue(result.get(0).contains(items.get(0).getAuthor()));
    }

    @Test
    void shouldReturnEmptyListForEmptyInput() {
        var result = service.toReportLines(List.of());

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnUpperCaseReportLines() {
        var result = service.toUpperReportLines(items);

        result.forEach(line -> assertEquals(line.toUpperCase(), line));
    }

    @Test
    void shouldReturnSameCountAsToReportLines() {
        var normal = service.toReportLines(items);
        var upper  = service.toUpperReportLines(items);

        assertEquals(normal.size(), upper.size());
    }

    @Test
    void shouldReturnUpperCaseVersionOfReportLine() {
        var normal = service.toReportLines(List.of(items.get(0)));
        var upper  = service.toUpperReportLines(List.of(items.get(0)));

        assertEquals(normal.get(0).toUpperCase(), upper.get(0));
    }
}

