package bp.biblioteka.solid.ocp;

import bp.biblioteka.strategy.item.PenaltyStrategy;

import java.util.HashMap;
import java.util.Map;

//Tydzień 7, zasada otwarte - zamnkięte data driven 1
//Możemy dynamicznie rejestrować nowe kary poprzez dodanie ich do mapy rejestru
public class PenaltyRegistry {
    private static final Map<String, PenaltyStrategy> strategies = new HashMap<>();

    public static void register(String type, PenaltyStrategy strategy) {
        strategies.put(type, strategy);
    }

    public static PenaltyStrategy getStrategy(String type) {
        PenaltyStrategy strategy = strategies.get(type);

        if (strategy == null) {
            throw new IllegalArgumentException("Unknown penalty strategy: " + type);
        }

        return strategy;
    }
}
