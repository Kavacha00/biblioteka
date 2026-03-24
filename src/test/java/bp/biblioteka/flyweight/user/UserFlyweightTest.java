package bp.biblioteka.flyweight.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserFlyweightTest {
    @Test
    void shouldReturnSameInstanceForSameRoleName() {
        Role role1 = RoleFactory.getRole("ADMIN");
        Role role2 = RoleFactory.getRole("ADMIN");

        assertSame(role1, role2);
    }

    @Test
    void shouldReturnDifferentInstancesForDifferentRoles() {
        Role admin = RoleFactory.getRole("ADMIN");
        Role user = RoleFactory.getRole("USER");

        assertNotSame(admin, user);
    }

    @Test
    void shouldCreateRoleWithCorrectName() {
        Role role = RoleFactory.getRole("MODERATOR");

        assertEquals("MODERATOR", role.getName());
    }

    @Test
    void shouldReusePreviouslyCreatedRole() {
        Role firstCall = RoleFactory.getRole("USER");
        Role secondCall = RoleFactory.getRole("USER");
        Role thirdCall = RoleFactory.getRole("USER");

        assertSame(firstCall, secondCall);
        assertSame(secondCall, thirdCall);
    }

}
