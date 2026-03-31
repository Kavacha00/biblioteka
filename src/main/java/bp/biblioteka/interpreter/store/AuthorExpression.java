package bp.biblioteka.interpreter.store;

import bp.biblioteka.entity.item.Book;

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
