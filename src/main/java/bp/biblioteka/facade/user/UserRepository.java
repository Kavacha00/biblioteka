package bp.biblioteka.facade.user;

import bp.biblioteka.entity.user.User;

public class UserRepository {
    private boolean isUserSaved = false;

    public void save(User user) {
        this.isUserSaved = true;
    }

    public boolean isUserSaved() {
        return isUserSaved;
    }
}
