package bp.biblioteka.command.store;

//Tydzień 5, Wzorzec Command 1
//Invoker — obiekt wywołujący polecenia
//Przyjmuje dowolne polecenie StoreCommand i je wykonuje
public class StoreCommandInvoker {
    public void run(StoreCommand command) {
        command.execute();
    }
}
// Koniec, Tydzień 5, Wzorzec Command 1