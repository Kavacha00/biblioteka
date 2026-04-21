package bp.biblioteka.solid.ocp;

import java.util.HashMap;
import java.util.Map;


//Tydzień 7, zasada otwarte - zamnkięte data driven 2
//Możemy dynamicznie rejestrować nowe typy zniżek
public class DiscountRegistry {
    private static final Map<String, Double> discounts = new HashMap<>();

    public void addDiscount(String type, double value) {
        discounts.put(type, value);
    }

    public double applyDiscount(String type, double value) {
        Double discount = discounts.get(type);

        if (discount == null) {
            throw new IllegalArgumentException("No discount of type: " + type);
        }

        return discount * value;
    }
}
