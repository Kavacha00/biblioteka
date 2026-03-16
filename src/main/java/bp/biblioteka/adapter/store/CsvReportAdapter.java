package bp.biblioteka.adapter.store;

import java.util.List;

public class CsvReportAdapter implements ReportService {

    private CsvReportGenerator csvReportGenerator;

    public CsvReportAdapter(CsvReportGenerator csvReportGenerator) {
        this.csvReportGenerator = csvReportGenerator;
    }

    @Override
    public void generateLoanReport(List<Loan> loans) {

        StringBuilder csvData = new StringBuilder();

        csvData.append("User,Book,StartDate,EndDate\n");

        for (Loan loan : loans) {
            csvData.append(loan.getUser().getName())
                    .append(",")
                    .append(loan.getBook().getTitle())
                    .append(",")
                    .append(loan.getStartDate())
                    .append(",")
                    .append(loan.getEndDate())
                    .append("\n");
        }

        csvReportGenerator.generateCsv(csvData.toString());
    }
}