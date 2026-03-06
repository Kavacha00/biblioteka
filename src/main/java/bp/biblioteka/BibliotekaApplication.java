package bp.biblioteka;

import bp.biblioteka.factories.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotekaApplication {



    public static void main(String[] args) {
//        SpringApplication.run(BibliotekaApplication.class, args);

        CDCreator cd = new CDCreator();
        BookCreator book = new BookCreator();

        Item item1 = cd.createItem("asfdd", "sds");

        item1.displayDetails();
    }

}
