package bp.biblioteka;

import bp.biblioteka.adapter.BookTranslateAdapter;
import bp.biblioteka.adapter.ItemTranslatorObjectAdapterImpl;
import bp.biblioteka.builder.item.BookBuilder;
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


        Item book = new Book("Pan Autor", "Abababa");
        System.out.println(book.describe());

        BookTranslateAdapter translateAdapter = new ItemTranslatorObjectAdapterImpl(book);

        System.out.println(translateAdapter.getPolishDescription());
        System.out.println(translateAdapter.getGermanDescription());
    }

}
