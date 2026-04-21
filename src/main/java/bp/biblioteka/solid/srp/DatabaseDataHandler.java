package bp.biblioteka.solid.srp;

// Tydzień 7, Zasada SRP 2
// Klasa skupia się wyłącznie na operacjach DML,
// zarządzając rekordami książek w systemie.

import bp.biblioteka.entity.item.Book;

public class DatabaseDataHandler {

    public void insertBook(Book book) {
        System.out.println("Dodawanie nowej książki: " + book.getTitle());
    }

    public void updateBook(Book book) {
        System.out.println("Aktualizacja danych istniejącej książki o ID: " + book.getId());
    }

    public void deleteBook(Book book) {
        System.out.println("Usuwanie książki z systemu: " + book.getTitle());
    }
}
// Koniec, Tydzień 7, Zasada SRP 2
