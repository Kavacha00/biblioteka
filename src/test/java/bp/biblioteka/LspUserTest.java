package bp.biblioteka;

import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.Employee;
import bp.biblioteka.entity.user.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LspUserTest {

    private void verifyUserLifecycle(User user) {
        assertFalse(user.isLoggedIn(), "Użytkownik nie powinien być zalogowany na starcie.");

        String loginMessage = user.logIn();
        assertNotNull(loginMessage, "Wiadomość logowania nie może być null.");
        assertTrue(user.isLoggedIn(), "Użytkownik powinien mieć status zalogowanego po wywołaniu logIn().");

        String logoutMessage = user.logOut();
        assertNotNull(logoutMessage, "Wiadomość wylogowania nie może być null.");
        assertFalse(user.isLoggedIn(), "Użytkownik nie powinien być zalogowany po wywołaniu logOut().");
    }

    @Test
    void shouldProcessEmployeeAsBaseUser() {
        User employee = new Employee("Jan Pracownik", "jan@biblioteka.pl", "emp1", "haslo123");

        verifyUserLifecycle(employee);
    }

    @Test
    void shouldProcessCustomerAsBaseUser() {
        User customer = new Customer("Anna Czytelnik", "anna@poczta.pl", "cus1", "haslo456");

        verifyUserLifecycle(customer);
    }
}
