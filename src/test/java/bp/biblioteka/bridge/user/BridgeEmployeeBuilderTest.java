package bp.biblioteka.bridge.user;

import bp.biblioteka.entity.user.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeBuilderBridgeTest {

    @Test
    void shouldCreateEmployeeUsingBuilderBridge() {
        EmployeeBuilder builder =
                new EmployeeBuilderBridge(new DefaultEmployeeBuilder());

        var employee = builder
                .name("John Doe")
                .email("John@doe.com")
                .login("John's Login")
                .password("John's Password")
                .build();

        assertNotNull(employee);
        assertInstanceOf(Employee.class, employee);
    }

    @Test
    void shouldCreateEmployeeWithCorrectFieldsUsingBuilderBridge() {
        EmployeeBuilder builder =
                new EmployeeBuilderBridge(new DefaultEmployeeBuilder());

        var employee = builder
                .name("John Doe")
                .email("John@doe.com")
                .login("John's Login")
                .password("John's Password")
                .build();

        assertEquals("John Doe", employee.getName());
        assertEquals("John@doe.com", employee.getEmail());
        assertEquals("John's Login", employee.getLogin());
        assertEquals("John's Password", employee.getPassword());
    }

    @Test
    void shouldResetBuilderAfterBuild() {
        EmployeeBuilder builder =
                new EmployeeBuilderBridge(new DefaultEmployeeBuilder());

        builder
                .name("John Doe")
                .email("John@doe.com")
                .login("John's Login")
                .password("John's Password")
                .build();

        var secondEmployee = builder.build();

        assertNull(secondEmployee.getName());
        assertNull(secondEmployee.getEmail());
        assertNull(secondEmployee.getLogin());
        assertNull(secondEmployee.getPassword());
    }

    @Test
    void shouldAllowFluentChaining() {
        EmployeeBuilder builder =
                new EmployeeBuilderBridge(new DefaultEmployeeBuilder());

        var employee = builder
                .name("John")
                .email("a@b.com")
                .login("login")
                .password("pass")
                .build();

        assertNotNull(employee);
    }

    @Test
    void shouldWorkWithRefinedBuilder() {
        EmployeeBuilder builder =
                new EmployeeBuilderBridge(new DefaultEmployeeBuilder());

        var employee = builder
                .name("John Doe")
                .build();

        assertEquals("John Doe", employee.getName());
    }

    @Test
    void shouldUseDifferentImplementation() {
        EmployeeBuilder builder =
                new EmployeeBuilderBridge(new DefaultEmployeeBuilder());

        var employee = builder
                .name("Jane Doe")
                .email("Jane@doe.com")
                .login("JaneLogin")
                .password("Secret")
                .build();

        assertEquals("Jane Doe", employee.getName());
    }
}