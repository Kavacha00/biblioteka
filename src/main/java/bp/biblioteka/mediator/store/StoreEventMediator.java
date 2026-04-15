package bp.biblioteka.mediator.store;

import bp.biblioteka.adapter.store.Loan;
import bp.biblioteka.adapter.store.ReportService;

//Tydzień 5, Wzorzec Mediator 1
//Centralny mediator obsługujący zdarzenia w systemie
//Decyduje, które serwisy powinny reagować na dane wydarzenie
public class StoreEventMediator implements StoreMediator {

    private NotificationService notificationService;
    private InventoryService inventoryService;
    private ReportService reportService;

    public StoreEventMediator(NotificationService notificationService,
                              InventoryService inventoryService,
                              ReportService reportService) {
        this.notificationService = notificationService;
        this.inventoryService = inventoryService;
        this.reportService = reportService;
    }

    @Override
    public void notify(Object sender, String event, Object data) {

        switch (event) {
            case "BOOK_LOANED":
                notificationService.sendLoanConfirmation((Loan) data);
                inventoryService.markAsUnavailable(((Loan)data).getBook());
                break;

            case "BOOK_RETURNED":
                notificationService.sendReturnConfirmation((Loan) data);
                inventoryService.markAsAvailable(((Loan)data).getBook());
                break;

            case "LOAN_EXTENDED":
                notificationService.sendExtensionInfo((Loan) data);
                break;
        }
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator 1