package bp.biblioteka.functional;

// Tydzień 10, Programowanie funkcyjne

import bp.biblioteka.entity.item.Item;
import bp.biblioteka.entity.store.Order;
import bp.biblioteka.entity.user.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


//Serwis demonstrujący strumieniowe przetwarzanie trzech różnych kolekcji.
public class StreamProcessingService {

    public List<String> getSortedTitlesUpperCase(List<Item> items) {
        return items.stream()
                .sorted(Comparator.comparing(Item::getTitle))
                .map(item -> item.getTitle().toUpperCase())
                .collect(Collectors.toList());
    }

    public void printSortedItems(List<Item> items) {
        System.out.println("=== Kolekcja 1: Item (posortowane tytuły) ===");
        getSortedTitlesUpperCase(items).forEach(t -> System.out.println("  " + t));
    }

    public List<String> getLoggedInEmails(List<User> users) {
        return users.stream()
                .filter(User::isLoggedIn)
                .map(User::getEmail)
                .collect(Collectors.toList());
    }

    public void printLoggedInEmails(List<User> users) {
        System.out.println("\n=== Kolekcja 2: User (e-maile zalogowanych) ===");
        List<String> emails = getLoggedInEmails(users);
        if (emails.isEmpty()) {
            System.out.println("  Brak zalogowanych użytkowników.");
        } else {
            emails.forEach(e -> System.out.println("  " + e));
        }
    }

    public long countActiveOrders(List<Order> orders) {
        return orders.stream()
                .map(Order::printStatus)
                .filter(status -> !status.equalsIgnoreCase("Nowe zamówienie"))
                .count();
    }

    public void printOrderStatuses(List<Order> orders) {
        System.out.println("\n=== Kolekcja 3: Order (statusy) ===");
        orders.stream()
                .map(Order::printStatus)
                .forEach(s -> System.out.println("  " + s));
        System.out.println("  Zamówień w toku (nie NEW): " + countActiveOrders(orders));
    }
}
// Koniec, Tydzień 10, Programowanie funkcyjne
