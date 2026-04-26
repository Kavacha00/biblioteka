package bp.biblioteka.solid.dip.report;

// Tydzień 8, Zasada DIP 2
// Moduł AuditManager operuje wyłącznie na abstrakcji ReportGenerator.
// Zmiana sposobu generowania raportu nie wymaga zmiany w logice menedżera.

public class AuditManager {
    private final ReportGenerator reportGenerator;

    public AuditManager(ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public void runDailyAudit(String auditData) {
        System.out.println("Rozpoczynanie codziennego audytu...");
        reportGenerator.generate(auditData);
    }
}
// Koniec, Tydzień 8, Zasada DIP 2