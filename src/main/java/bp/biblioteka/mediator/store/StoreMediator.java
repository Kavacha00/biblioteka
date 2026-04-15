package bp.biblioteka.mediator.store;

//Tydzień 5, Wzorzec Mediator 1
//Interfejs Mediatora
//Umożliwia komunikację pośrednią między serwisami
public interface StoreMediator {
    void notify(Object sender, String event, Object data);
}
// Koniec, Tydzień 5, Wzorzec Mediator 1