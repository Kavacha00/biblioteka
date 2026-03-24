package bp.biblioteka.flyweight.item;

import bp.biblioteka.bridge.item.CollectionFormat;
import bp.biblioteka.bridge.item.DigitalFormat;
import bp.biblioteka.bridge.item.ItemFormat;
import bp.biblioteka.bridge.item.PhysicalFormat;

import java.util.HashMap;
import java.util.Map;

public class FormatFactory {
    private static final Map<String, ItemFormat> formatMap = new HashMap<>();
    public static ItemFormat getItemFormat(String format){
        String key = format.toLowerCase();
        ItemFormat itemFormat = formatMap.get(key);

        if (itemFormat == null) {
            switch (key) {
                case "physical":
                    itemFormat = new PhysicalFormat();
                    break;
                case "digital":
                    itemFormat = new DigitalFormat();
                    break;
                case "collection":
                    itemFormat = new CollectionFormat();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown format: " + format);

            }
            formatMap.put(key, itemFormat);
//            System.out.println(format);
        }
        return itemFormat;
    }

}
