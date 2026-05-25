package bp.biblioteka.entity.item;

import bp.biblioteka.bridge.item.ItemFormat;

import java.util.UUID;

// Tydzień 8, Zasada LSP 2
// Implementuje metodę describe() i nadpisuje getInternalDetails() w sposób niewprowadzający
// niespodziewanych błędów (np. nie rzuca wyjatków UnsupportedOperationException).


//Tydzień 2, Wzorzec Prototype 3
//Klasa tworzy kopie obiektów implementując interfejs Cloneable
public class Book extends Item implements Cloneable {
    public Book(String author, String title, ItemFormat format) {

        super(author, title,  format);
    }

    @Override
    public Book clone() {
        try {
            Book book = (Book) super.clone();
            book.id = UUID.randomUUID();
            return book;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String describe() {
        return "Book: " + this.getAuthor() + " | " + this.getTitle()
                + " [" + this.getFormat().format()+ "]";
    }

    @Override
    public String getInternalDetails() {
        return String.valueOf(this.getId());
    }



}
//Koniec, Tydzień 2, Wzorzec Prototype 3,

// Koniec, Tydzień 8, Zasada LSP 2
