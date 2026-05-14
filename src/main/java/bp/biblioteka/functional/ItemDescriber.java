package bp.biblioteka.functional;

import bp.biblioteka.entity.item.Item;

// Tydzień 10, Programowanie funkcyjne
// Własny interfejs funkcyjny #2
// Generuje sformatowany opis przedmiotu (Item) w postaci ciągu znaków.
// Przykład użycia z wyrażeniem lambda: item -> "item: " + item.describe()

public interface ItemDescriber {
    String describe(Item item);
}
// Koniec, Tydzień 10, Programowanie funkcyjne