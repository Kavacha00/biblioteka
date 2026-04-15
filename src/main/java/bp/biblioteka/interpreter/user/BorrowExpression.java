package bp.biblioteka.interpreter.user;

import bp.biblioteka.entity.item.Item;
import bp.biblioteka.entity.user.User;

public class BorrowExpression implements Expression{
    private final Item item;

    public BorrowExpression(Item item){
        this.item = item;
    }

    @Override
    public void interpret(User user) {
        System.out.println(user.getName() + " borrowed " + item.getAuthor() + " " + item.getTitle());
    }
}
