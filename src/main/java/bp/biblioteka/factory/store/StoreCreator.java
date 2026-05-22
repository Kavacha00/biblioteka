package bp.biblioteka.factory.store;

import bp.biblioteka.entity.store.Store;

// Tydzień 2, Wzorzec Factory Method 1
// Klasa bazowa kreatora definiuje interfejs metody fabrycznej (createStore).
// Odsuwa ona decyzję o tym, jaka konkretna podklasa Store zostanie utworzona, do klas potomnych.

public abstract class StoreCreator {
    public abstract Store createStore(String name, String email, String address, String phoneNumber);
}

// Koniec, Tydzień 2, Wzorzec Factory Method 1