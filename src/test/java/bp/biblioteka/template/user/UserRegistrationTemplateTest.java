package bp.biblioteka.template.user;

import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.Employee;
import bp.biblioteka.entity.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTemplateTest {
    @Test
    void shouldCreateCustomerUsingCustomerRegistration() {
        CustomerRegistration registration = new CustomerRegistration();

        User user = registration.register("John Doe", "john@doe.com", "John's Login", "John's Password");

        assertInstanceOf(Customer.class, user);
    }

    @Test
    void shouldCreateEmployeeUsingEmployeeRegistration() {
        EmployeeRegistration registration = new EmployeeRegistration();

        User user = registration.register("John Doe", "john@doe.com", "John's Login", "John's Password");

        assertInstanceOf(Employee.class, user);
    }

    @Test
    void shouldCreateCustomerWithCorrectFields() {
        CustomerRegistration registration = new CustomerRegistration();

        User user = registration.register("John Doe", "john@doe.com", "John's Login", "John's Password");

        assertEquals("John Doe", user.getName());
        assertEquals("john@doe.com", user.getEmail());
        assertEquals("John's Login", user.getLogin());
        assertEquals("John's Password", user.getPassword());
    }

    @Test
    void shouldCreateEmployeeWithCorrectFields() {
        EmployeeRegistration registration = new EmployeeRegistration();

        User user = registration.register("John Doe", "john@doe.com", "John's Login", "John's Password");

        assertEquals("John Doe", user.getName());
        assertEquals("john@doe.com", user.getEmail());
        assertEquals("John's Login", user.getLogin());
        assertEquals("John's Password", user.getPassword());
    }

    @Test
    void shouldAssignCustomerRoleToCustomer() {
        CustomerRegistration registration = new CustomerRegistration();

        User user = registration.register("John Doe", "john@doe.com", "John's Login", "John's Password");

        assertTrue(user.getRoles().stream()
                .anyMatch(role -> role.getName().equals("CUSTOMER")));
    }

    @Test
    void shouldAssignEmployeeRoleToEmployee() {
        EmployeeRegistration registration = new EmployeeRegistration();

        User user = registration.register("John Doe", "john@doe.com", "John's Login", "John's Password");

        assertTrue(user.getRoles().stream()
                .anyMatch(role -> role.getName().equals("EMPLOYEE")));
    }

    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        CustomerRegistration registration = new CustomerRegistration();

        assertThrows(IllegalArgumentException.class, () ->
                registration.register(null, "john@doe.com", "John's Login", "John's Password"));
    }

    @Test
    void shouldThrowExceptionWhenEmailIsBlank() {
        CustomerRegistration registration = new CustomerRegistration();

        assertThrows(IllegalArgumentException.class, () ->
                registration.register("John Doe", " ", "John's Login", "John's Password"));
    }

    @Test
    void shouldThrowExceptionWhenLoginIsNull() {
        EmployeeRegistration registration = new EmployeeRegistration();

        assertThrows(IllegalArgumentException.class, () ->
                registration.register("John Doe", "john@doe.com", null, "John's Password"));
    }

    @Test
    void shouldThrowExceptionWhenPasswordIsBlank() {
        EmployeeRegistration registration = new EmployeeRegistration();

        assertThrows(IllegalArgumentException.class, () ->
                registration.register("John Doe", "john@doe.com", "John's Login", " "));
    }

    @Test
    void shouldNotAssignEmployeeRoleToCustomer() {
        CustomerRegistration registration = new CustomerRegistration();

        User user = registration.register("John Doe", "john@doe.com", "John's Login", "John's Password");

        assertTrue(user.getRoles().stream()
                .noneMatch(role -> role.getName().equals("EMPLOYEE")));
    }

    @Test
    void shouldNotAssignCustomerRoleToEmployee() {
        EmployeeRegistration registration = new EmployeeRegistration();

        User user = registration.register("John Doe", "john@doe.com", "John's Login", "John's Password");

        assertTrue(user.getRoles().stream()
                .noneMatch(role -> role.getName().equals("CUSTOMER")));
    }

}
