package bp.biblioteka.mediator.store;

public interface StoreMediator {
    void notify(Object sender, String event, Object data);
}
