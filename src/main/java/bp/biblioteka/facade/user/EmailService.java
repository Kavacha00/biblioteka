package bp.biblioteka.facade.user;

import bp.biblioteka.entity.user.User;

public class EmailService {
    private boolean emailSent = false;

    public void sendWelcomeEmail(User user) {
        this.emailSent = true;
    }

    public boolean isEmailSent() {
        return emailSent;
    }
}
