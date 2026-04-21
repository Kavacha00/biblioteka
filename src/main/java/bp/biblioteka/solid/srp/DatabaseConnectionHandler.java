package bp.biblioteka.solid.srp;

// Tydzień 7, Zasada SRP 1
// Klasa odpowiada wyłącznie za techniczne aspekty
// zarządzania sesją i połączeniem z infrastrukturą bazy danych biblioteki.

public class DatabaseConnectionHandler {

    public void connect() {
        System.out.println("Nawiązywanie połączenia z bazą danych...");
    }

    public void disconnect() {
        System.out.println("Zamykanie połączenia z bazą danych...");
    }
}
// Koniec, Tydzień 7, Zasada SRP 1
