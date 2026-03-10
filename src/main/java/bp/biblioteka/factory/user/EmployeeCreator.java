package bp.biblioteka.factory.user;

import bp.biblioteka.entity.user.Employee;
import bp.biblioteka.entity.user.User;

public final class EmployeeCreator extends UserCreator{
    private static volatile EmployeeCreator instance;

    private EmployeeCreator() {
        super();
    }

    public static EmployeeCreator getInstance(){
        EmployeeCreator result = instance;
        if(result != null){
            return result;
        }
        synchronized(EmployeeCreator.class){
            if (instance == null) {
                instance = new EmployeeCreator();
            }
            return instance;
        }
    }


    @Override
    public User createUser(String name, String email, String login, String password) {
        return new Employee(name, email, login, password);
    }
}
