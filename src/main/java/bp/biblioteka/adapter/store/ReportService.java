package bp.biblioteka.adapter.store;

import java.util.List;

public interface ReportService {

    void generateLoanReport(List<Loan> loans);

}
