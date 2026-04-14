package bp.biblioteka.state.item;

import bp.biblioteka.entity.item.Item;

public interface ItemState {
    boolean borrowItem(Item item);
    boolean returnItem(Item item);
    String getStateName();
}
