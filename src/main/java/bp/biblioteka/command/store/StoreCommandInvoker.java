package bp.biblioteka.command.store;

public class StoreCommandInvoker {
    public void run(StoreCommand command) {
        command.execute();
    }
}
