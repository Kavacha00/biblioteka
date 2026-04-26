package bp.biblioteka.solid.dip.storage;

// Tydzień 8, Zasada DIP 3
// Klasa InventoryService zależy tylko od abstrakcji DataStorage.
// Chroni to logikę biznesową przed szczegółami niskopoziomowymi.
public class InventoryService {
    private final DataStorage storage;

    public InventoryService(DataStorage storage) {
        this.storage = storage;
    }

    public void registerNewDelivery(String itemName, int amount) {
        System.out.println("Przetwarzanie nowej dostawy w systemie...");
        storage.saveItem(itemName, amount);
    }
}
// Koniec, Tydzień 8, Zasada DIP 3