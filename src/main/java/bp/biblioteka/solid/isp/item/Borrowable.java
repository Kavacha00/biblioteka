package bp.biblioteka.solid.isp.item;

// Tydzień 8, Zasada ISP 1
// Interfejs wydzielony z grubego interfejsu.
// Odpowiada wyłącznie za operacje wypożyczania przedmiotów fizycznych.

public interface Borrowable {
    void borrowPhysicalItem();
    void returnPhysicalItem();
}
// Koniec, Tydzień 8, Zasada ISP 1
