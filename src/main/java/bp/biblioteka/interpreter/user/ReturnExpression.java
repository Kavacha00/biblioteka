package bp.biblioteka.interpreter.user;

import bp.biblioteka.entity.item.Item;
import bp.biblioteka.entity.user.User;

public class ReturnExpression implements Expression {
    private final Item item;

    public ReturnExpression(Item item) {
        this.item = item;
    }

    @Override
    public void interpret(User user) {
        System.out.println(user.getName() + " returned " + item.getAuthor() + " " + item.getTitle());
    }
}
