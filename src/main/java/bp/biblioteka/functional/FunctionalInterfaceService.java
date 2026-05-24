package bp.biblioteka.functional;

import bp.biblioteka.entity.item.Item;
import bp.biblioteka.entity.user.User;

import java.util.List;

// Tydzień 10, Programowanie funkcyjne
/*
 * Serwis demonstrujący własne interfejsy funkcyjne
 * oraz ich implementacje za pomocą wyrażeń lambda.
*/
public class FunctionalInterfaceService {
    private final ItemPricer standardDiscount = (basePrice, rate) -> basePrice * (1 - rate);
    private final ItemPricer holidayDiscount  = (basePrice, rate) -> basePrice * (1 - rate) - 5.0;

    private final ItemDescriber catalogDescriber = item -> "[KATALOG] " + item.describe();
    private final ItemDescriber shortDescriber   = item -> item.getTitle() + " (" + item.getAuthor() + ")";

    private final UserNotifier emailNotifier = (user, msg) -> user.notify(msg);
    private final UserNotifier logNotifier   = (user, msg) -> {
        String entry = "[LOG] Powiadomienie dla " + user.getName() + ": " + msg;
        System.out.println(entry);
        return entry;
    };

    public double calculateStandardDiscount(double basePrice, double discountRate) {
        return standardDiscount.calculatePrice(basePrice, discountRate);
    }

    public double calculateHolidayDiscount(double basePrice, double discountRate) {
        return holidayDiscount.calculatePrice(basePrice, discountRate);
    }

    public String describeCatalog(Item item) {
        return catalogDescriber.describe(item);
    }

    public String describeShort(Item item) {
        return shortDescriber.describe(item);
    }

    public String notifyByEmail(User user, String message) {
        return emailNotifier.notify(user, message);
    }

    public String notifyByLog(User user, String message) {
        return logNotifier.notify(user, message);
    }

    public void demonstratePricing(double basePrice, double discountRate) {
        System.out.printf("Cena bazowa:        %.2f zł%n", basePrice);
        System.out.printf("Rabat standardowy:  %.2f zł%n",
                calculateStandardDiscount(basePrice, discountRate));
        System.out.printf("Rabat świąteczny:   %.2f zł%n",
                calculateHolidayDiscount(basePrice, discountRate));
    }

    public void demonstrateDescribing(List<Item> items) {
        items.forEach(item -> {
            System.out.println("katalog : " + describeCatalog(item));
            System.out.println("skrócony: " + describeShort(item));
        });
    }

    public void demonstrateNotifying(List<User> users, String message) {
        users.forEach(user -> {
            System.out.println("email: " + notifyByEmail(user, message));
            notifyByLog(user, message);
        });
    }
}
// Koniec, Tydzień 10, Programowanie funkcyjne
