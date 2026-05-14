package bp.biblioteka.functional;

// Tydzień 10, Programowanie funkcyjne
// Własny interfejs funkcyjny #1
// Oblicza cenę końcową przedmiotu na podstawie ceny bazowej i stopy rabatu (0.0 - 1.0).
// Przykład użycia z wyrażeniem lambda: (base, rate) -> base * (1 - rate)

public interface ItemPricer {
    double calculatePrice(double basePrice, double discountRate);
}
// Koniec, Tydzień 10, Programowanie funkcyjne