package bp.biblioteka.interpreter.item;

import bp.biblioteka.entity.item.Item;

public class TitleExpression implements ItemExpression {
    private String targetTitle;
    public TitleExpression(String targetTitle) {
        this.targetTitle = targetTitle.toLowerCase();
    }

    @Override
    public boolean interpret(Item item) {
        return item.getTitle().toLowerCase().contains(targetTitle);
    }
}
