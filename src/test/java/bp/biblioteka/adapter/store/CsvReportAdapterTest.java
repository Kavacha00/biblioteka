//package bp.biblioteka.adapter.store;
//
//import bp.biblioteka.entity.item.Book;
//import bp.biblioteka.entity.user.Customer;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CsvReportAdapterTest {
//
//    @Test
//    void shouldGenerateCsvReportWithCorrectData() {
//        TestCsvReportGenerator generator = new TestCsvReportGenerator();
//        CsvReportAdapter adapter = new CsvReportAdapter(generator);
//
//        Loan loan = new Loan();
//        loan.setUser(new Customer(
//                "Jan Kowalski",
//                "jan@mail.com",
//                "jan123",
//                "pass"
//        ));
//        loan.setBook(new Book("Sapkowski", "Wiedźmin"));
//        loan.setStartDate(LocalDate.of(2024, 1, 1));
//        loan.setEndDate(LocalDate.of(2024, 1, 10));
//
//        adapter.generateLoanReport(List.of(loan));
//
//        String result = generator.generatedCsv;
//
//        assertTrue(result.contains("Jan Kowalski"));
//        assertTrue(result.contains("Wiedźmin"));
//        assertTrue(result.contains("2024-01-01"));
//        assertTrue(result.contains("2024-01-10"));
//    }
//
//    @Test
//    void shouldGenerateCsvWithHeaderWhenListIsEmpty() {
//        TestCsvReportGenerator generator = new TestCsvReportGenerator();
//        CsvReportAdapter adapter = new CsvReportAdapter(generator);
//
//        adapter.generateLoanReport(List.of());
//
//        assertEquals("User,Book,StartDate,EndDate\n", generator.generatedCsv);
//    }
//
//    @Test
//    void shouldCallGeneratorOnce() {
//        TestCsvReportGenerator generator = new TestCsvReportGenerator();
//        CsvReportAdapter adapter = new CsvReportAdapter(generator);
//
//        adapter.generateLoanReport(List.of());
//
//        assertEquals(1, generator.callCount);
//    }
//
//    static class TestCsvReportGenerator extends CsvReportGenerator {
//        String generatedCsv;
//        int callCount = 0;
//
//        @Override
//        public void generateCsv(String csvData) {
//            this.generatedCsv = csvData;
//            callCount++;
//        }
//    }
//}
//
