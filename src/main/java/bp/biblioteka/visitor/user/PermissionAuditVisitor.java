package bp.biblioteka.visitor.user;

import bp.biblioteka.adapter.user.OidcUserAdapter;
import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.Employee;

//Tydzień 6, Wzorzec Visitor 2
//Generuje raport uprawnień
public class PermissionAuditVisitor implements UserVisitor {
    @Override
    public String visit(Customer customer) {
        return String.format(
                "Customer [%s] permissions: BROWSE_STORE, ADD_TO_CART, PLACE_ORDER, VIEW_OWN_ORDERS",
                customer.getLogin()
        );
    }

    @Override
    public String visit(Employee employee) {
        return String.format(
                "Employee [%s] permissions: BROWSE_STORE, MANAGE_INVENTORY, VIEW_ALL_ORDERS, MANAGE_CUSTOMERS",
                employee.getLogin()
        );
    }

    @Override
    public String visit(OidcUserAdapter adapter) {
        return String.format(
                "OIDC User [%s] permissions: EXTERNAL_AUTH_LOGIN, BROWSE_STORE, ADD_TO_CART, PLACE_ORDER",
                adapter.getLogin()
        );
    }
}
