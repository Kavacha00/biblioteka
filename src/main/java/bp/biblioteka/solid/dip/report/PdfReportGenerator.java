package bp.biblioteka.solid.dip.report;

// Tydzień 8, Zasada DIP 2
// Niskopoziomowy szczegół implementacyjny (generowanie PDF).
public class PdfReportGenerator extends BaseReportGenerator {
    @Override
    public void generate(String data) {
        prepareDocumentTemplate();
        System.out.println("Eksportowanie danych do formatu PDF: " + data);
    }
}
// Koniec, Tydzień 8, Zasada DIP 2
