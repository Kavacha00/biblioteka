package bp.biblioteka.proxy.item;

import bp.biblioteka.entity.item.Item;
import bp.biblioteka.entity.user.Employee;
import bp.biblioteka.entity.user.User;

//Tydzień 4, Wzorzec Proxy 3
//Uprawniony użytkownik (pracownik) ma dostęp do ukrytych
//danych - ID przedmiotu
public class SecuredItemProxy extends Item {

    private Item item;
    private User currentUser;

    public SecuredItemProxy(Item item, User currentUser) {
        super(item.getAuthor(), item.getTitle(), item.getFormat());
        this.id = item.getId();
        this.item = item;
        this.currentUser = currentUser;
    }

    @Override
    public String describe() {
        return item.describe();
    }

    @Override
    public String getInternalDetails() {
        if(this.currentUser instanceof Employee)
            return item.getInternalDetails();
        else return "Odmowa dostępu";
    }
}
//Koniec, Tydzień 4, Wzorzec Proxy 3