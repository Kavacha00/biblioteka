package bp.biblioteka.facede.user;

import bp.biblioteka.facade.user.EmailService;
import bp.biblioteka.facade.user.PasswordService;
import bp.biblioteka.facade.user.UserRegistrationFacade;
import bp.biblioteka.facade.user.UserRepository;
import bp.biblioteka.proxy.user.UserService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserFacadeTest {

    @Test
    void shouldRegisterUserSuccessfully() {
        UserService userService = new UserService();
        PasswordService passwordService = new PasswordService();
        EmailService emailService = new EmailService();
        UserRepository userRepository = new UserRepository();

        UserRegistrationFacade facade = new UserRegistrationFacade(
                userService,
                passwordService,
                emailService,
                userRepository
        );

        facade.register("John", "john@mail.com", "john123", "secret");

        assertTrue(passwordService.isPasswordHashed());
        assertTrue(userRepository.isUserSaved());
        assertTrue(emailService.isEmailSent());
    }

    @Test
    void shouldThrowExceptionWhenUserAlreadyExists() {

        UserService userService = new UserService() {
            @Override
            public boolean exists(String value) {
                return true; // simulate existing user
            }
        };

        PasswordService passwordService = new PasswordService();
        EmailService emailService = new EmailService();
        UserRepository userRepository = new UserRepository();

        UserRegistrationFacade facade = new UserRegistrationFacade(
                userService,
                passwordService,
                emailService,
                userRepository
        );


        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                facade.register("John", "john@mail.com", "john123", "secret")
        );

        assertEquals("User already exists", exception.getMessage());

        assertFalse(passwordService.isPasswordHashed());
        assertFalse(userRepository.isUserSaved());
        assertFalse(emailService.isEmailSent());
    }
}