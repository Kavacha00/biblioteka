package bp.biblioteka.factory.item;

import bp.biblioteka.bridge.item.ItemFormat;
import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.item.Item;

//Tydzień 2, Wzorzec Factory i Singleton 3
//Klasa tworząca obiekty,
//zapewnia istnienie tylko jednej instancji klasy
public final class BookCreator extends ItemCreator {
    private static volatile  BookCreator instance;
    private BookCreator() {
        super();
    }
    public static BookCreator getInstance() {
        if (instance == null) {
            synchronized (BookCreator.class) {
                if (instance == null) {
                    instance = new BookCreator();
                }
            }
        }
        return instance;
    }

    @Override
    public Item createItem(String author, String title, ItemFormat format){
        return new Book(author, title,  format);
    }
}
//Koniec, Tydzień 2, Wzorzec Factory i Singleton 3