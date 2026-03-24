package bp.biblioteka.bridge.item;

//Tydzień 3, Wzorzec Bridge
//Podział itemu na format fizyczny i cyfrowy
public interface ItemFormat {
    String format();
    boolean isDownloadable();
}
//Koniec, Tydzień 3, Wzorzec Bridge