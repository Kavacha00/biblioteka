package bp.biblioteka.proxy.user;

import bp.biblioteka.entity.user.User;

public class UserService {
    public boolean isActive(User user){
        return true;
    }

    public boolean exists(String email) {
        return false;
    }
}
