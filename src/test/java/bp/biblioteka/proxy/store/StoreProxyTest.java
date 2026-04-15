package bp.biblioteka.proxy.store;

import bp.biblioteka.adapter.store.CsvReportAdapter;
import bp.biblioteka.adapter.store.CsvReportGenerator;
import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.Employee;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class StoreProxyTest {

    @Test
    void shouldAllowReportGenerationForEmployee() {
        Employee employee = new Employee("Jan", "jan@mail", "jan123", "pw");

        CsvReportAdapter adapter = new CsvReportAdapter(new CsvReportGenerator());
        ReportServiceProxy proxy = new ReportServiceProxy(adapter, employee);

        assertDoesNotThrow(() ->
                proxy.generateLoanReport(Collections.emptyList()));
    }

    @Test
    void shouldBlockReportGenerationForCustomer() {
        Customer customer = new Customer("Anna", "anna@mail", "anna123", "pw");

        CsvReportAdapter adapter = new CsvReportAdapter(new CsvReportGenerator());
        ReportServiceProxy proxy = new ReportServiceProxy(adapter, customer);

        assertThrows(SecurityException.class,
                () -> proxy.generateLoanReport(Collections.emptyList()));
    }
}
