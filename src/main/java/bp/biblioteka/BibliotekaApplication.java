package bp.biblioteka;

import bp.biblioteka.builder.item.BookBuilder;
import bp.biblioteka.entity.item.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotekaApplication {



    public static void main(String[] args) {
//        SpringApplication.run(BibliotekaApplication.class, args);

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

        BookBuilder builder = new BookBuilder();

        Book originalBook = builder
                .author("Frank Herbert")
                .title("Diuna")
                .build();

        Book clonedBook = originalBook.clone();

        System.out.println("Oryginał: " + originalBook.describe() + " | ID: " + originalBook.getId());
        System.out.println("Klon: " + clonedBook.describe() + " | ID: " + clonedBook.getId());

    }

}
