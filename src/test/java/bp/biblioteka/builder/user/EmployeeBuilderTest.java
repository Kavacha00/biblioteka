package bp.biblioteka.builder.user;

import bp.biblioteka.entity.user.Employee;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeBuilderTest {

    @Test
    void shouldCreateEmployeeUsingEmployeeBuilder() {
        EmployeeBuilder builder = new EmployeeBuilder();

        var employee = builder
                .name("John Doe")
                .email("John@doe.com")
                .login("John's Login")
                .password("John's Password")
                .build();

        assertInstanceOf(Employee.class, employee);
    }

    @Test
    void shouldCreateEmployeeWithCorrectFields() {
        EmployeeBuilder builder = new EmployeeBuilder();

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
    void shouldCreateEmployeeWithoutPassword() {
        EmployeeBuilder builder = new EmployeeBuilder();

        var employee = builder
                .name("John Doe")
                .email("John@doe.com")
                .login("John's Login")
                .build();

        assertNull(employee.getPassword());
    }

    @Test
    void shouldClearFieldsAfterCallingReset() throws Exception {
        EmployeeBuilder builder = new EmployeeBuilder();
        Field field  = EmployeeBuilder.class.getDeclaredField("name");
        field.setAccessible(true);

        builder.name("John Doe");
        String fieldValue = (String) field.get(builder);

        assertEquals("John Doe", fieldValue);

        builder.reset();
        fieldValue = (String) field.get(builder);

        assertNull(fieldValue);

    }

    @Test
    void shouldClearFieldsAfterBuildingEmployee() throws Exception {
        EmployeeBuilder builder = new EmployeeBuilder();
        Field field  = EmployeeBuilder.class.getDeclaredField("name");
        field.setAccessible(true);

        builder.name("John Doe");
        String fieldValue = (String) field.get(builder);

        assertEquals("John Doe", fieldValue);

        builder.build();
        fieldValue = (String) field.get(builder);

        assertNull(fieldValue);
    }

}
