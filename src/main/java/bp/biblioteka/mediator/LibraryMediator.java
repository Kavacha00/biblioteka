package bp.biblioteka.mediator;

import bp.biblioteka.entity.item.Item;
import bp.biblioteka.entity.user.User;

public interface LibraryMediator {
    void borrowItem(User user, Item item);
    void returnItem(User user, Item item);
}
