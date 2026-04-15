package bp.biblioteka.state.item;

import bp.biblioteka.entity.item.Item;

public class BorrowedState implements ItemState {

    @Override
    public boolean borrowItem(Item item){
        System.out.println("Przedmiot jest już wypożyczony");
        return false;
    }

    @Override
    public boolean returnItem(Item item){
        item.setItemState(new AvailableState());

        item.notifyObservers("dostępny");

        return true;
    }

    @Override
    public String getStateName() {
        return "Wypożyczony";
    }
}
//Koniec, Tydzień 6, Wzorzec State 3