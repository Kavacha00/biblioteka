package bp.biblioteka.visitor.user;

import bp.biblioteka.adapter.user.OidcUserAdapter;
import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.Employee;

public interface UserVisitor {
    String visit(Customer customer);
    String visit(Employee employee);

    String visit(OidcUserAdapter adapter);
}
