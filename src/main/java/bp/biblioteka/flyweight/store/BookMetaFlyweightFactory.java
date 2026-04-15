package bp.biblioteka.flyweight.store;

import java.util.HashMap;
import java.util.Map;

//Tydzień 4, Wzorzec Flyweight 1
//Fabryka Flyweight dla metadanych książek
//Tworzy i zarządza współdzielonymi instancjami BookMetaFlyweight
public class BookMetaFlyweightFactory {

    private static final Map<String, BookMetaFlyweight> cache = new HashMap<>();

    public static BookMetaFlyweight getMetadata(String author, String title, String format) {

        String key = author + "|" + title + "|" + format;

        if (!cache.containsKey(key)) {
            cache.put(key, new BookMetaFlyweight(author, title, format));
        }

        return cache.get(key);
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight 1
