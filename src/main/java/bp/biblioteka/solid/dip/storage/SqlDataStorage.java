package bp.biblioteka.solid.dip.storage;

// Tydzień 8, Zasada DIP 3
// Niskopoziomowa implementacja zapisu za pomocą zapytań SQL.

public class SqlDataStorage extends AbstractDatabaseStorage {
    @Override
    public void saveItem(String itemName, int quantity) {
        connect();
        System.out.println("Wykonanie SQL: INSERT INTO inventory (name, qty) VALUES ('" + itemName + "', " + quantity + ")");
        disconnect();
    }
}
// Koniec, Tydzień 8, Zasada DIP 3
