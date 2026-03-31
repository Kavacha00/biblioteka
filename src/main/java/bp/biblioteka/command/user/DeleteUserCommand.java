package bp.biblioteka.command.user;

import bp.biblioteka.entity.user.User;
import bp.biblioteka.proxy.user.UserService;

public class DeleteUserCommand implements UserCommand {
    private final UserService userService;
    private final User user;

    public DeleteUserCommand(UserService userService, User user) {
        this.userService = userService;
        this.user = user;
    }


    @Override
    public void execute() {
        this.userService.delete(user);
    }
}
