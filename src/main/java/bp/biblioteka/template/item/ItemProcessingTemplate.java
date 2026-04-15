package bp.biblioteka.template.item;

import bp.biblioteka.entity.item.Item;

//Tydzień 6, Wzorzec Template 3
//proces dodawania nowych przedmiotów
public abstract class ItemProcessingTemplate {
    public final void processNewItem(Item newItem) {
        registerInSystem(newItem);
        store(newItem);
        markAsReady(newItem);
    }

    private void registerInSystem(Item newItem) {
        System.out.println("Rejestrowanie przedmiotu");
    }
    protected abstract void store(Item newItem);
    protected void markAsReady(Item newItem) {
        System.out.println("Przedmiot został pomyślnie dodany");
    }
}
//Koniec, Tydzień 6, Wzorzec Template 3