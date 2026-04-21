package bp.biblioteka.solid.srp;

// Tydzień 7, Zasada SRP 3
// Klasa odpowiada za operacje DDL,
// umożliwiając dynamiczne zarządzanie schematem bazy danych poprzez tworzenie i usuwanie tabel.

public class DatabaseStructureHandler {

    public void createTable(String tableName) {
        System.out.println("Tworzenie tabeli w bazie danych: " + tableName);
    }

    public void dropTable(String tableName) {
        System.out.println("Usuwanie tabeli ze struktury bazy danych: " + tableName);
    }
}
// Koniec, Tydzień 7, Zasada SRP 3