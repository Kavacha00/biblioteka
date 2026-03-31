package bp.biblioteka.interpreter.item;

import bp.biblioteka.entity.item.Item;

public class AndExpression implements ItemExpression {
    private ItemExpression expression1;
    private ItemExpression expression2;

    public AndExpression(ItemExpression expression1, ItemExpression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(Item item){
        return expression1.interpret(item) && expression2.interpret(item);
    }
}
//Koniec, Tydzień 5, Wzorzec Interpreter 3
