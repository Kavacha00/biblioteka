package bp.biblioteka.facade.user;

import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.User;
import bp.biblioteka.proxy.user.UserService;

// Tydzień 4, Wzorzec Facade 2
// Fasada użytkownika bibliotecznego
// Upraszcza rejestrację użytkownika
public class UserRegistrationFacade {

    private final UserService userService;
    private final PasswordService passwordService;
    private final EmailService emailService;
    private final UserRepository userRepository;

    public UserRegistrationFacade(UserService userService,
                                  PasswordService passwordService,
                                  EmailService emailService,
                                  UserRepository userRepository) {
        this.userService = userService;
        this.passwordService = passwordService;
        this.emailService = emailService;
        this.userRepository = userRepository;
    }

    public void register(String name, String email, String login, String password) {
        if (userService.exists(email) || userService.exists(login)) {
            throw new RuntimeException("User already exists");
        }

        String hashedPassword = passwordService.hash(password);

        User user = new Customer(name, email, login, hashedPassword);
        userRepository.save(user);

        emailService.sendWelcomeEmail(user);
    }
}
