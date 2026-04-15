package bp.biblioteka.interpreter.store;

import bp.biblioteka.entity.item.Book;

//Tydzień 5, Wzorzec Interpreter 1
//Interfejs wyrażenia Interpreter
//Reprezentuje regułę logiczną, którą można zastosować do obiektu Book
public interface Expression {
    boolean interpret(Book book);
}
// Koniec, Tydzień 5, Wzorzec Interpreter 1