package bp.biblioteka.entity.user;

import bp.biblioteka.factory.user.EmployeeCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrototypeTest {

    @Test
    void shouldCloneEmployeeWithCorrectFields(){
        var factory = EmployeeCreator.getInstance();
        User user = factory.createUser("John Doe",
                "John@doe.com", "John's Login", "John's Password");
        User clone = user.clone();

        assertNotSame(user, clone);

        assertEquals(user.getId(), clone.getId());
        assertEquals(user.getName(), clone.getName());
        assertEquals(user.getEmail(), clone.getEmail());
        assertEquals(user.getLogin(), clone.getLogin());
        assertEquals(user.getPassword(), clone.getPassword());
    }
}
