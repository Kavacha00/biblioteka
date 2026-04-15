// Tydzień 6, Wzorzec Visitor 1
// Implementacja wzorca Visitor wariantu opartego na sprawdzaniu typów (Type-Checking Visitor).
// Pozwala na dodanie nowej funkcjonalności audytu bez dodawania metody accept() i modyfikowania istniejących klas.
package bp.biblioteka.visitor.store;

import bp.biblioteka.entity.store.OnlineStore;
import bp.biblioteka.entity.store.PhysicalStore;
import bp.biblioteka.entity.store.Store;

public class StoreAuditVisitor {

    private String auditResult;

    public void visit(Store store) {
        if (store instanceof PhysicalStore) {
            PhysicalStore physicalStore = (PhysicalStore) store;
            auditResult = "Audyt fizyczny dla: " + physicalStore.getName() + ", Adres: " + physicalStore.getAddress();
        } else if (store instanceof OnlineStore) {
            OnlineStore onlineStore = (OnlineStore) store;
            auditResult = "Audyt cyfrowy dla: " + onlineStore.getName() + ", Email: " + onlineStore.getEmail();
        } else {
            auditResult = "Brak dedykowanego audytu dla ogólnego typu sklepu: " + store.getName();
        }
    }

    public String getAuditResult() {
        return auditResult;
    }
}
// Koniec, Tydzień 6, Wzorzec Visitor 1