package bp.biblioteka.mediator;

import bp.biblioteka.entity.item.Item;
import bp.biblioteka.entity.user.User;

//Tydzień 5, Wzorzec Mediator 3
//Użytkownik wypożycza przedmiot
public class LibraryMediatorImpl implements LibraryMediator{
    @Override
    public void borrowItem(User user, Item item){

        boolean success = item.getItemState().borrowItem(item);
        if(success){
            System.out.println("Przedmiot został wypożyczony");
        }
    }

    @Override
    public void returnItem(User user, Item item){
        boolean success = item.getItemState().returnItem(item);
        if(success){
            System.out.println("Przedmiot został zwrócony");
        }
    }
}
//Koniec, Tydzień 5, Wzorzec Mediator 3