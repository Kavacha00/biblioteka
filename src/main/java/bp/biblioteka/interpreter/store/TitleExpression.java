package bp.biblioteka.interpreter.store;

import bp.biblioteka.entity.item.Book;

//Tydzień 5, Wzorzec Interpreter 1
//Wyrażenie terminalne sprawdzające tytuł książki
//Zwraca true, jeśli tytuł książki jest równy tytułowi podanemu w zapytaniu
public class TitleExpression implements Expression {
    private String title;

    public TitleExpression(String title) {
        this.title = title;
    }

    @Override
    public boolean interpret(Book book) {
        return book.getTitle().equalsIgnoreCase(title);
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter 1