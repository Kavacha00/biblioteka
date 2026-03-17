package bp.biblioteka.adapter;

import bp.biblioteka.entity.item.Item;

public class ItemTranslatorObjectAdapterImpl implements BookTranslateAdapter {
    private Item libraryItem;
    public ItemTranslatorObjectAdapterImpl(Item libraryItem) {
        this.libraryItem = libraryItem;
    }
    private String getEnglishDescription(){
        return libraryItem.describe();
    }

    @Override
    public String getPolishDescription(){
        String description = getEnglishDescription();
        return translateText(description, "to Polish");
    }

    @Override
    public String getGermanDescription(){
        String description = getEnglishDescription();
        return translateText(description, "to German");
    }

    private String translateText(String text, String language){
        switch (language){
            case "to Polish":
                return text.replace("Book:", "Książka:");

                case "to German":
                    return text.replace("Book:", "Buch:");

                    default:
                        return text;
        }
    }
}
//Koniec, Tydzień 3, wzorzec Adapter