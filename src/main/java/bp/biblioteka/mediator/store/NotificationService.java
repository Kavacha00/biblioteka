package bp.biblioteka.mediator.store;

import bp.biblioteka.adapter.store.Loan;

//Tydzień 5, Wzorzec Mediator 1
//Serwis odpowiedzialny za wysyłanie powiadomień e-mail
//Mediator decyduje, kiedy i jakie powiadomienia wysłać
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
// Koniec, Tydzień 5, Wzorzec Mediator 1