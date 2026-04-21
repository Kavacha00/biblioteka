package bp.biblioteka.solid.ocp;

import bp.biblioteka.bridge.item.ItemFormat;
import bp.biblioteka.entity.item.Item;

import java.util.HashMap;
import java.util.Map;

//Tydzień 7, zasada otwarte - zamnkięte data driven 3
//Możemy dynamicznie rejestrować nowe typy itemów poprzez dodanie ich do mapy rejestru
public class ItemRegistry {
    private static final Map<String, ItemFactory> registry = new HashMap<>();

    public static void register(String type, ItemFactory factory) {
        registry.put(type, factory);
    }

    public static Item create(String type, String artist, String title, ItemFormat format) {
        ItemFactory factory = registry.get(type);

        if (factory == null) {
            throw new IllegalArgumentException("ItemFactory " + type + " not registered");
        }

        return factory.create(artist, title, format);
    }
}
