package bp.biblioteka.command.item;

import bp.biblioteka.entity.item.Item;

//Tydzień 5, Wzorzec Command 3
//zmiana tytułu przedmiotu
public class ChangeTitleCommand implements ItemCommand {
    private Item item;
    private String newTitle;

    public ChangeTitleCommand(Item item, String newTitle) {
        this.item = item;
        this.newTitle = newTitle;
    }

    @Override
    public void execute() {
        this.item.setTitle(this.newTitle);
    }
}
//Koniec, Tydzień 5, Wzorzec Command 3