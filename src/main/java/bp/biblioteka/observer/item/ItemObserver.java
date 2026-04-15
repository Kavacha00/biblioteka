package bp.biblioteka.observer.item;


//Tydzień 6, Wzorzec Observer 3
//Powiadomienie obserwujących o dostępności przedmiotu
//implementacja w pakiecie entity w klasach Customer i Item
public interface ItemObserver {
    void update(String itemName, String message);
}
//Koniec, Tydzień 6, Wzorzec Observer 3