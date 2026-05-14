package bp.biblioteka.functional;

import bp.biblioteka.entity.user.User;

// Tydzień 10, Programowanie funkcyjne
// Własny interfejs funkcyjny #3
// Wysyła powiadomienie do użytkownika i zwraca potwierdzenie jako String.
// Przykład użycia z wyrażeniem lambda: (user, msg) -> user.notify(msg)

public interface UserNotifier {
    String notify(User user, String message);
}

// Koniec, Tydzień 10, Programowanie funkcyjne