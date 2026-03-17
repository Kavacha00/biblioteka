package bp.biblioteka.adapter.store;

import java.util.List;

//Tydzień 3, Wzorzec Adapter 1,
// Adapter umożliwia dostosowanie interfejsu CsvReportGenerator
// do wymaganego interfejsu ReportService używanego w systemie.
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
//Koniec, Tydzień 3, Wzorzec Adapter 1