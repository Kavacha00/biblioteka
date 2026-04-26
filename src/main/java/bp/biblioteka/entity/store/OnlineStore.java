package bp.biblioteka.entity.store;

// Tydzień 8, Zasada LSP 3
// Klasa pochodna implementuje procesowanie zamówień
// bez łamania zachowań i typów zwracanych oczekiwanych przez klasę bazową.

public class OnlineStore extends Store {

    public OnlineStore(String name, String email, String address, String phoneNumber) {
        super(name, email, address, phoneNumber);
    }

    @Override
    public String processOrder() {
        String result = "Processing order in online store";
        // Tydzień 6, Wzorzec Observer 1
        // Powiadomienie obserwatorów o akcji
        notifyObservers(result);
        return result;
    }
}

// Koniec, Tydzień 8, Zasada LSP 3