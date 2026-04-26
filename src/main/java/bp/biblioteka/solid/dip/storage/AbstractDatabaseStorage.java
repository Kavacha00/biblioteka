package bp.biblioteka.solid.dip.storage;

// Tydzień 8, Zasada DIP 3
// Abstrakcyjna klasa bazowa dla operacji bazodanowych.

public abstract class AbstractDatabaseStorage implements DataStorage {
    protected void connect() {
        System.out.println("Otwieranie bezpiecznego połączenia z bazą danych...");
    }

    protected void disconnect() {
        System.out.println("Zamykanie połączenia z bazą danych...");
    }
}
// Koniec, Tydzień 8, Zasada DIP 3