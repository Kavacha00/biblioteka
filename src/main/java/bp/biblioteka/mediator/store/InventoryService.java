package bp.biblioteka.mediator.store;

import bp.biblioteka.entity.item.Book;

//Tydzień 5, Wzorzec Mediator 1
//Serwis odpowiedzialny za stan magazynowy książek
//Reaguje na zdarzenia za pośrednictwem mediatora
public class InventoryService {
    public void markAsUnavailable(Book book) {
        System.out.println("Inventory: " + book.getTitle() + " marked as unavailable");
    }
    public void markAsAvailable(Book book) {
        System.out.println("Inventory: " + book.getTitle() + " is available again");
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator 1