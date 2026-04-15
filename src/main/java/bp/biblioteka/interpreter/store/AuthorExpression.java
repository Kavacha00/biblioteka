package bp.biblioteka.interpreter.store;

import bp.biblioteka.entity.item.Book;

//Tydzień 5, Wzorzec Interpreter 1
//Wyrażenie terminalne sprawdzające autora książki
//Zwraca true, jeśli autor książki pasuje do podanego w zapytaniu
public class AuthorExpression implements Expression {
    private String author;

    public AuthorExpression(String author) {
        this.author = author;
    }

    @Override
    public boolean interpret(Book book) {
        return book.getAuthor().equalsIgnoreCase(author);
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter 1