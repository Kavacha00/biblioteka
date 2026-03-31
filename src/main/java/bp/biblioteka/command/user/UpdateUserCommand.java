package bp.biblioteka.command.user;

import bp.biblioteka.entity.user.User;
import bp.biblioteka.proxy.user.UserService;

public class UpdateUserCommand implements UserCommand {
    private final UserService userService;
    private final User user;
    private final String newEmail;

    public UpdateUserCommand(UserService userService, User user, String newEmail) {
        this.userService = userService;
        this.user = user;
        this.newEmail = newEmail;
    }

    @Override
    public void execute() {
        this.userService.updateEmail(this.user, this.newEmail);
    }
}
