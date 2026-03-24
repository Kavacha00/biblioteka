package bp.biblioteka.proxy.store;
import bp.biblioteka.adapter.store.Loan;
import bp.biblioteka.adapter.store.ReportService;
import bp.biblioteka.entity.user.Employee;
import bp.biblioteka.entity.user.User;

import java.util.List;

//Tydzień 4, Wzorzec Proxy 1
//Proxy dla serwisu raportowego
// Kontroluje dostęp do generowania raportów w zależności od typu użytkownika
public class ReportServiceProxy implements ReportService {

    private final ReportService reportService;
    private final User user;

    public ReportServiceProxy(ReportService reportService, User user) {
        this.reportService = reportService;
        this.user = user;
    }

    private boolean hasAccess() {
        return user instanceof Employee;
    }

    @Override
    public void generateLoanReport(List<Loan> loans) {
        if (!hasAccess()) {
            throw new SecurityException("Access denied: only employees can generate reports.");
        }

        System.out.println("Proxy: Access granted for user: " + user.getName());
        reportService.generateLoanReport(loans);
    }
}
// Koniec, Tydzień 4, Wzorzec Proxy 1