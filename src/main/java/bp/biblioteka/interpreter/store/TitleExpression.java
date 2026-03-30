package bp.biblioteka.interpreter.store;

import bp.biblioteka.entity.item.Book;

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
