package bp.biblioteka.adapter;

//Tydzień 3, wzorzec Adapter
//Możliwość zmiany języka opisu
public interface BookTranslateAdapter {
    public String getPolishDescription();
    public String getGermanDescription();
}
