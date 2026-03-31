package bp.biblioteka.command.item;

import java.util.Stack;

public class CommandInvoker {
    private Stack<ItemCommand> commandStack = new Stack<>();

    public void execute(ItemCommand command) {
        command.execute();
        commandStack.push(command);
    }

}
