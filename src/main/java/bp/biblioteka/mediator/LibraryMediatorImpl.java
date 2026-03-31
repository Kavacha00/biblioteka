package bp.biblioteka.mediator;

import bp.biblioteka.entity.item.Item;
import bp.biblioteka.entity.user.User;

//Tydzień 5, Wzorzec Mediator 3
//Użytkownik wypożycza przedmiot
public class LibraryMediatorImpl implements LibraryMediator{
    @Override
    public void borrowItem(User user, Item item){
        if(item.isBorrowed())
            System.out.println("The item is already borrowed");
        else
            item.setBorrowed(true);
    }

    @Override
    public void returnItem(User user, Item item){
        if(item.isBorrowed())
            item.setBorrowed(false);
        else
            System.out.println("The item is not borrowed");
    }
}
//Koniec, Tydzień 5, Wzorzec Mediator 3