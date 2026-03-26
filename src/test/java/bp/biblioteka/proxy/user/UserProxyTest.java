package bp.biblioteka.proxy.user;

import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.Employee;
import bp.biblioteka.entity.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserProxyTest {

    @Test
    void shouldLogInWhenUserIsActive() {
        UserService userService = new UserService();

        Employee employee = new Employee("John", "john@mail.com", "john", "123");
        UserProxy proxy = new UserProxy(employee, userService);

        proxy.logIn();

        assertTrue(employee.isLoggedIn());
    }

    @Test
    void shouldNotLogInWhenUserIsInactive() {
        UserService userService = new UserService() {
            @Override
            public boolean isActive(User user) {
                return false;
            }
        };

        Customer customer = new Customer("Anna", "anna@mail.com", "anna", "123");
        UserProxy proxy = new UserProxy(customer, userService);

        proxy.logIn();

        assertFalse(customer.isLoggedIn());
    }
}