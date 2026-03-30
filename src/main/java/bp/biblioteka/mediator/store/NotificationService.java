package bp.biblioteka.mediator.store;

import bp.biblioteka.adapter.store.Loan;

public class NotificationService {
    public void sendLoanConfirmation(Loan loan) {
        System.out.println("Email: Loan confirmation sent to " + loan.getUser().getName());
    }
    public void sendReturnConfirmation(Loan loan) {
        System.out.println("Email: Return confirmation sent.");
    }
    public void sendExtensionInfo(Loan loan) {
        System.out.println("Email: Loan extended.");
    }
}
