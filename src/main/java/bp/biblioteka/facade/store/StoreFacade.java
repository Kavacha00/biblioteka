package bp.biblioteka.facade.store;

import bp.biblioteka.adapter.store.ReportService;
import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.user.User;
import bp.biblioteka.adapter.store.Loan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Tydzień 4, Wzorzec Facade 1
// Fasada sklepu bibliotecznego
// Upraszcza interakcję z wypożyczaniem książek i generowaniem raportów
public class StoreFacade {

    private List<Loan> loans = new ArrayList<>();
    private ReportService reportService;

    public StoreFacade(ReportService reportService) {
        this.reportService = reportService;
    }

    public Loan loanBook(User user, Book book) {
        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setStartDate(LocalDate.now());
        loan.setEndDate(LocalDate.now().plusDays(14));

        loans.add(loan);
        return loan;
    }

    public void returnBook(Loan loan) {
        loans.remove(loan);
    }

    public void generateReport() {
        reportService.generateLoanReport(loans);
    }

    public List<Loan> getLoans() {
        return loans;
    }
}
// Koniec, Tydzień 4, Wzorzec Facade 1