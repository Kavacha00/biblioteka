package bp.biblioteka.solid.isp.store;

// Tydzień 8, Zasada ISP 3
// Interfejs wydzielony z grubego interfejsu.
// Obsługuje transakcje cyfrowe, takie jak przelewy czy BLIK.

public interface OnlineProcessor {
    void processOnlinePayment();
}
// Koniec, Tydzień 8, Zasada ISP 3