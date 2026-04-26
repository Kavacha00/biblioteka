package bp.biblioteka.solid.dip.report;

// Tydzień 8, Zasada DIP 2
// Klasa abstrakcyjna grupująca wspólne operacje dla raportów.

public abstract class BaseReportGenerator implements ReportGenerator {
    protected void prepareDocumentTemplate() {
        System.out.println("Przygotowywanie oficjalnego szablonu raportu...");
    }
}
// Koniec, Tydzień 8, Zasada DIP 2