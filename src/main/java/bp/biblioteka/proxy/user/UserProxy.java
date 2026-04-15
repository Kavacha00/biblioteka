package bp.biblioteka.proxy.user;

import bp.biblioteka.entity.user.User;

//Tydzień 4, Wzorzec Proxy 2
//Proxy dla użytkownika
//Umożliwia logowanie tylko aktywnym użytkownikom
public class UserProxy {
    private final User user;
    private final UserService userService;

    public UserProxy(User user, UserService userService) {
        this.user = user;
        this.userService = userService;
    }

    public void logIn() {
        if (userService.isActive(user)) {
            this.user.logIn();
        }
    }

}
