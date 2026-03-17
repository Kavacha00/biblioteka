package bp.biblioteka;

import bp.biblioteka.adapter.BookTranslateAdapter;
import bp.biblioteka.adapter.ItemTranslatorObjectAdapterImpl;
import bp.biblioteka.bridge.DigitalFormat;
import bp.biblioteka.bridge.ItemFormat;
import bp.biblioteka.bridge.PhysicalFormat;
import bp.biblioteka.builder.item.BookBuilder;
import bp.biblioteka.composite.AuthorCollection;
import bp.biblioteka.decorator.BestsellerDecorator;
import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.item.Item;
import bp.biblioteka.factory.item.BookCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotekaApplication {



    public static void main(String[] args) {
//        SpringApplication.run(BibliotekaApplication.class, args);

        //builder
//        BookBuilder bookBuilder = new BookBuilder();
//        Book myBook = bookBuilder
//                .title("Wiedźmin: Ostatnie życzenie")
//                .author("Andrzej Sapkowski")
//                .build();
//
//        Book myBook1 = bookBuilder
//                .build();
//
//        System.out.println(myBook.describe());
//        System.out.println(myBook1.describe());

        //prototype
//        BookBuilder builder = new BookBuilder();
//
//        Book originalBook = builder
//                .author("Frank Herbert")
//                .title("Diuna")
//                .build();
//
//        Book clonedBook = originalBook.clone();
//
//        System.out.println("Oryginał: " + originalBook.describe() + " | ID: " + originalBook.getId());
//        System.out.println("Klon: " + clonedBook.describe() + " | ID: " + clonedBook.getId());

//        BookCreator factory1 = BookCreator.getInstance();
//
//        BookCreator factory2 = BookCreator.getInstance();
//
//        System.out.println("Czy factory1 i factory2 to ten sam obiekt? " + (factory1 == factory2));
//
//        Item book1 = factory1.createItem("Andrzej Sapkowski", "Wiedźmin");
//        Item book2 = factory1.createItem("J.R.R. Tolkien", "Hobbit");
//
//        System.out.println(book1.describe());
//        System.out.println(book2.describe());


//        Item book = new Book("Pan Autor", "Abababa");
//        System.out.println(book.describe());
//
//        BookTranslateAdapter translateAdapter = new ItemTranslatorObjectAdapterImpl(book);
//
//        System.out.println(translateAdapter.getPolishDescription());
//        System.out.println(translateAdapter.getGermanDescription());

//        Item book1 = new Book("Andrzej Sapkowski", "Ostatnie Życzenie");
//        Item book2 = new Book("Andrzej Sapkowski", "Miecz Przeznaczenia");
//        Item book3 = new Book("Andrzej Sapkowski", "Krew Elfów");
//
//        Item book4 = new Book("Frank Herbert", "Diuna");
//
//        AuthorCollection sapkowskiCollection = new AuthorCollection("Andrzej Sapkowski");
//
//        sapkowskiCollection.addItem(book1);
//        sapkowskiCollection.addItem(book2);
//        sapkowskiCollection.addItem(book3);
//
//        sapkowskiCollection.addItem(book4);
//
//        System.out.println(sapkowskiCollection.describe());


//        Item normalBook = new Book("J.K. Rowling", "Harry Potter i Kamień Filozoficzny");
//        System.out.println(normalBook.describe());
//
//        Item hitBook = new BestsellerDecorator(normalBook);
//        System.out.println(hitBook.describe());

        ItemFormat physical = new PhysicalFormat();
        ItemFormat digital = new DigitalFormat();

        Item paperBook = new Book("Andrzej Sapkowski", "Wiedźmin", physical);
        Item eBook = new Book("J.R.R. Tolkien", "Hobbit", digital);

        System.out.println(paperBook.describe());
        System.out.println("Czy można pobrać? " + paperBook.getFormat().isDownloadable());

        System.out.println("\n" + eBook.describe());
        System.out.println("Czy można pobrać? " + eBook.getFormat().isDownloadable());
    }

}
