package bp.biblioteka.proxy.user;

import bp.biblioteka.entity.user.User;

public class UserService {
    public boolean isActive(User user){
        return true;
    }

    public boolean exists(String email) {
        return false;
    }

    public String login(User user) {
        return user.logIn();
    }

    public String logout(User user) {
        return user.logOut();
    }

    public void register(User user) {
        System.out.println("Registering user: " + user.getLogin());
    }

    public void updateEmail(User user, String newEmail) {
        System.out.println("Updating email from " + user.getEmail() + " to " + newEmail);
        user.setEmail(newEmail);
    }

    public void delete(User user) {
        System.out.println("Deleting user: " + user.getLogin());
    }


}
