package bp.biblioteka.visitor.user;

import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.Employee;
import bp.biblioteka.entity.user.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserVisitorTest {

    @Test
    void shouldReturnCustomerPermissionsForCustomer() {
        Customer customer = new Customer("John Doe", "john@doe.com", "John's Login", "John's Password");
        PermissionAuditVisitor visitor = new PermissionAuditVisitor();

        String result = customer.accept(visitor);

        assertEquals(
                "Customer [John's Login] permissions: BROWSE_STORE, ADD_TO_CART, PLACE_ORDER, VIEW_OWN_ORDERS",
                result
        );
    }

    @Test
    void shouldReturnEmployeePermissionsForEmployee() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");
        PermissionAuditVisitor visitor = new PermissionAuditVisitor();

        String result = employee.accept(visitor);

        assertEquals(
                "Employee [John's Login] permissions: BROWSE_STORE, MANAGE_INVENTORY, VIEW_ALL_ORDERS, MANAGE_CUSTOMERS",
                result
        );
    }

    @Test
    void shouldIncludeLoginInCustomerPermissionAudit() {
        Customer customer = new Customer("John Doe", "john@doe.com", "John's Login", "John's Password");
        PermissionAuditVisitor visitor = new PermissionAuditVisitor();

        String result = customer.accept(visitor);

        assertTrue(result.contains("John's Login"));
    }

    @Test
    void shouldIncludeLoginInEmployeePermissionAudit() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");
        PermissionAuditVisitor visitor = new PermissionAuditVisitor();

        String result = employee.accept(visitor);

        assertTrue(result.contains("John's Login"));
    }

    @Test
    void shouldNotReturnEmployeePermissionsForCustomer() {
        Customer customer = new Customer("John Doe", "john@doe.com", "John's Login", "John's Password");
        PermissionAuditVisitor visitor = new PermissionAuditVisitor();

        String result = customer.accept(visitor);

        assertFalse(result.contains("MANAGE_INVENTORY"));
        assertFalse(result.contains("VIEW_ALL_ORDERS"));
        assertFalse(result.contains("MANAGE_CUSTOMERS"));
    }

    @Test
    void shouldNotReturnCustomerPermissionsForEmployee() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");
        PermissionAuditVisitor visitor = new PermissionAuditVisitor();

        String result = employee.accept(visitor);

        assertFalse(result.contains("ADD_TO_CART"));
        assertFalse(result.contains("PLACE_ORDER"));
        assertFalse(result.contains("VIEW_OWN_ORDERS"));
    }

    @Test
    void shouldAuditAllUsersInList() {
        List<User> users = List.of(
                new Customer("John Doe", "john@doe.com", "John's Login", "John's Password"),
                new Employee("Jane Doe", "jane@doe.com", "Jane's Login", "Jane's Password")
        );
        PermissionAuditVisitor visitor = new PermissionAuditVisitor();

        List<String> results = users.stream()
                .map(user -> user.accept(visitor))
                .toList();

        assertTrue(results.get(0).contains("Customer"));
        assertTrue(results.get(1).contains("Employee"));
    }

    @Test
    void shouldDispatchCorrectlyWithoutInstanceof() {
        User customer = new Customer("John Doe", "john@doe.com", "John's Login", "John's Password");
        User employee = new Employee("Jane Doe", "jane@doe.com", "Jane's Login", "Jane's Password");
        PermissionAuditVisitor visitor = new PermissionAuditVisitor();

        String customerResult = customer.accept(visitor);
        String employeeResult = employee.accept(visitor);

        assertTrue(customerResult.startsWith("Customer"));
        assertTrue(employeeResult.startsWith("Employee"));
    }
}