package bp.biblioteka.adapter.store;

import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Loan {

    private User user;
    private Book book;
    private LocalDate startDate;
    private LocalDate endDate;

}
