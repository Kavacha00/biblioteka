package bp.biblioteka.functional;

// Tydzień 10, Programowanie funkcyjne

import bp.biblioteka.bridge.item.DigitalFormat;
import bp.biblioteka.bridge.item.ItemFormat;
import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.item.Item;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Serwis demonstrujący użycie wbudowanych interfejsów Predicate i Function.

public class PredicateFunctionService {
    private final Predicate<Item> isBook    = item -> item instanceof Book;
    private final Predicate<Item> isDigital = item -> item.getFormat() instanceof DigitalFormat;

    private final Predicate<Item> isDigitalBook = isBook.and(isDigital);

    private final Function<Item, String> toReportLine = item ->
            String.format("%-35s | autor: %-20s | format: %s",
                    item.getTitle(), item.getAuthor(), item.getFormat());

    private final Function<Item, String> toUpperReportLine =
            toReportLine.andThen(String::toUpperCase);


    public List<Item> getDigitalBooks(List<Item> items) {
        return items.stream()
                .filter(isDigitalBook)
                .collect(Collectors.toList());
    }

    public List<Item> getNonBooks(List<Item> items) {
        return items.stream()
                .filter(isBook.negate())
                .collect(Collectors.toList());
    }

    public void printPredicateResults(List<Item> items) {
        System.out.println("=== Predicate<Item> ===");

        System.out.println("  isBook.and(isDigital) – cyfrowe książki:");
        getDigitalBooks(items)
                .stream()
                .map(Item::describe)
                .forEach(d -> System.out.println("    " + d));

        System.out.println("  isBook.negate() – przedmioty inne niż książka:");
        getNonBooks(items)
                .stream()
                .map(Item::describe)
                .forEach(d -> System.out.println("    " + d));
    }

    public List<String> toReportLines(List<Item> items) {
        return items.stream()
                .map(toReportLine)
                .collect(Collectors.toList());
    }

    public List<String> toUpperReportLines(List<Item> items) {
        return items.stream()
                .map(toUpperReportLine)
                .collect(Collectors.toList());
    }

    public void printFunctionResults(List<Item> items) {
        System.out.println("\n=== Function<Item, String> ===");

        List<Item> books = items.stream().filter(isBook).collect(Collectors.toList());

        System.out.println("  toReportLine (książki):");
        toReportLines(books).forEach(r -> System.out.println("    " + r));

        System.out.println("  toReportLine.andThen(toUpperCase):");
        toUpperReportLines(books).forEach(r -> System.out.println("    " + r));
    }
}
// Koniec, Tydzień 10, Programowanie funkcyjne

