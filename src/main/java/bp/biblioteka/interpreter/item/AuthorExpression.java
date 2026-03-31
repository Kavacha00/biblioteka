package bp.biblioteka.interpreter.item;

import bp.biblioteka.entity.item.Item;

public class AuthorExpression implements ItemExpression {
    private String targetAuthor;
    public AuthorExpression(String author) {
        this.targetAuthor = author.toLowerCase();
    }

    @Override
    public boolean interpret(Item item) {
        return item.getAuthor().toLowerCase().contains(targetAuthor);
    }
}
