package bp.biblioteka.visitor.user;

import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.Employee;

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
}
