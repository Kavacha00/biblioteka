package bp.biblioteka.state.item;

import bp.biblioteka.entity.item.Item;

// Tydzień 6, Wzorzec State 3
//Wprowadzenie stanów przedmiotu (wypożyczony, dostępny)
//zamiast zmiennej isBorrowed w klasie Item

public interface ItemState {
    boolean borrowItem(Item item);
    boolean returnItem(Item item);
    String getStateName();
}
