package bp.biblioteka.interpreter.item;

import bp.biblioteka.entity.item.Item;

//Tydzień 5, Wzorzec Interpreter 3
//Filtrowanie przedmiotów po
//autorze i tytule
public interface ItemExpression {
    boolean interpret(Item item);
}
