package bp.biblioteka.mediator.user;

import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.User;
import bp.biblioteka.proxy.user.UserService;

//Tydzień 5, Wzorzec Mediator 2
//Mediator wywołuje metody serwisu (troche jak controller)
public class UserMediatorImpl implements UserMediator {
    private final UserService userService;

    public UserMediatorImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void notify(UserPanel sender, String event, Object data) {
        switch (event) {
            case "login" -> sender.showMessage(userService.login((User) data));
            case "logout" -> sender.showMessage(userService.logout((User) data));
            default -> sender.showMessage("Unknown event: " + event);
        }
    }
}
//Koniec, Tydzień 5, Wzorzec Mediator 2