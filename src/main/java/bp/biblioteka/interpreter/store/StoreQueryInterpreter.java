package bp.biblioteka.interpreter.store;

//Tydzień 5, Wzorzec Interpreter 1
//Interpreter zapytań tekstowych
//Zamienia proste komendy tekstowe na obiekty Expression
//Obsługiwane polecenia: AUTHOR "<autor>", TITLE "<tytuł>"
public class StoreQueryInterpreter {

    public Expression parse(String query) {
        String[] parts = query.split(" ", 2);

        switch (parts[0]) {
            case "AUTHOR":
                return new AuthorExpression(parts[1].replace("\"", ""));

            case "TITLE":
                return new TitleExpression(parts[1].replace("\"", ""));

            default:
                throw new IllegalArgumentException("Unknown query");
        }
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter 1