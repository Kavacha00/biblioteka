package bp.biblioteka.factory.user;

import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.Employee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserFactoryTest {

    @Test
    void shouldCreateCustomerUsingCustomerFactory() {
        CustomerCreator factory = new CustomerCreator();

        var user = factory.createUser("John Doe",
                "John@doe.com", "John's Login", "John's Password");

        assertFalse(user instanceof Employee);
        assertInstanceOf(Customer.class, user);
    }

    @Test
    void shouldCreateEmployeeUsingEmployeeFactory() {
        EmployeeCreator factory = new EmployeeCreator();

        var user = factory.createUser("John Doe",
                "John@doe.com", "John's Login", "John's Password");

        assertFalse(user instanceof Customer);
        assertInstanceOf(Employee.class, user);
    }

    @Test
    void shouldCreateEmployeeWithCorrectFields() {
        EmployeeCreator factory = new EmployeeCreator();

        var user = factory.createUser("John Doe",
                "John@doe.com", "John's Login", "John's Password");

        assertEquals("John Doe", user.getName());
        assertEquals("John@doe.com", user.getEmail());
        assertEquals("John's Login", user.getLogin());
        assertEquals("John's Password", user.getPassword());
    }

    @Test
    void shouldCreateCustomerWithCorrectFields() {
        CustomerCreator factory = new CustomerCreator();

        var user = factory.createUser("John Doe",
                "John@doe.com", "John's Login", "John's Password");

        assertEquals("John Doe", user.getName());
        assertEquals("John@doe.com", user.getEmail());
        assertEquals("John's Login", user.getLogin());
        assertEquals("John's Password", user.getPassword());
    }
}