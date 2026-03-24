package bp.biblioteka.facade.user;

public class PasswordService {
    private boolean passwordHashed = false;

    public String hash(String password) {
        this.passwordHashed = true;
        return "hashedPassword";
    }

    public boolean isPasswordHashed() {
        return passwordHashed;
    }
}
