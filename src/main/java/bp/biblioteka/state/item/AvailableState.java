package bp.biblioteka.state.item;

import bp.biblioteka.entity.item.Item;

public class AvailableState implements ItemState{

    @Override
    public boolean borrowItem(Item item){
        item.setItemState(new BorrowedState());
        return true;
    }

    @Override
    public boolean returnItem(Item item){
        System.out.println("Przedmiot już został zwrócony");
        return false;
    }

    @Override
    public String getStateName() {
        return "Dostępny";
    }
}
//Koniec, Tydzień 6, Wzorzec State 3