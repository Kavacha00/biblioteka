package bp.biblioteka.mediator.user;

public interface UserMediator {
    void notify(UserPanel sender, String event, Object data);
}
