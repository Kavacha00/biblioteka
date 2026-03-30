package bp.biblioteka.mediator.store;

import bp.biblioteka.entity.item.Book;

public class InventoryService {
    public void markAsUnavailable(Book book) {
        System.out.println("Inventory: " + book.getTitle() + " marked as unavailable");
    }
    public void markAsAvailable(Book book) {
        System.out.println("Inventory: " + book.getTitle() + " is available again");
    }
}
