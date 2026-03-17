package bp.biblioteka.bridge;

//Tydzień 3, Wzorzec Bridge
//Podział itemu na format fizyczny i cyfrowy
public interface ItemFormat {
    String format();
    boolean isDownloadable();
}
//Koniec, Tydzień 3, Wzorzec Bridge