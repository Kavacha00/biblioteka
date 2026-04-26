package bp.biblioteka.entity.store;

import bp.biblioteka.observer.store.StoreObserver;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Tydzień 8, Zasada LSP 3
// Klasa Store definiuje nadrzędny kontrakt (processOrder()),
// który musi być respektowany przez wszystkie podklasy, by zagwarantować pełną wymienność obiektów.

@Getter
public abstract class Store implements Cloneable {
    protected UUID id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    // Tydzień 6, Wzorzec Observer 1
    // Lista obserwatorów
    // transient zapobiega problemom przy ewentualnej serializacji
    private transient List<StoreObserver> observers;

    public Store(String name, String email, String address, String phoneNumber) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.observers = new ArrayList<>();
    }

    // Tydzień 6, Wzorzec Observer 1
    // Metody zarządzające
    public void addObserver(StoreObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(StoreObserver observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(String message) {
        for (StoreObserver observer : observers) {
            observer.update(this, message);
        }
    }
    // Koniec, Tydzień 6, Wzorzec Observer 1

    @Override
    public Store clone() {
        try {
            Store cloned = (Store) super.clone();
            cloned.observers = new ArrayList<>();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public abstract String processOrder();
}
// Koniec, Tydzień 8, Zasada LSP 3