package bp.biblioteka.flyweight.user;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RoleFactory {

    private static final Map<String, Role> roles = new ConcurrentHashMap<>();

    public static Role getRole(String name) {
        return roles.computeIfAbsent(name, Role::new);
    }
}