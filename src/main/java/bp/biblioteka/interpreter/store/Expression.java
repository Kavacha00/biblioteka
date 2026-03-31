package bp.biblioteka.interpreter.store;

import bp.biblioteka.entity.item.Book;

public interface Expression {
    boolean interpret(Book book);
}

