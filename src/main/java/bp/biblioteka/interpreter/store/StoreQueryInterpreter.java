package bp.biblioteka.interpreter.store;

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
