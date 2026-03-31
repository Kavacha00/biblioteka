package bp.biblioteka.interpreter.user;

import bp.biblioteka.entity.item.Book;
import bp.biblioteka.entity.item.Item;

//Tydzień 5, Wzorzec Interpreter 2
//Interpreter odczytuje czy uzytkownik wypozyczyl czy zwrocil dana ksiazke

public class ExpressionInterpreter {
    public static Expression parseExpression(String expression) {
        String[] parts = expression.split(" ", 2);
        String action = parts[0].toLowerCase();

        if (parts.length < 2 || !parts[1].contains(" by ")) {
            throw new IllegalArgumentException("Command must include book title and author (e.g., 'borrow The Hobbit by Tolkien')");
        }

        String[] bookParts = parts[1].split(" by ", 2);
        String title = bookParts[0].trim();
        String author = bookParts[1].trim();

        Item item = new Book(title, author, null);


        return switch (action) {
            case "borrow" -> new BorrowExpression(item);
            case "return" -> new ReturnExpression(item);
            default -> throw new IllegalArgumentException("Unknown command: " + expression);
        };
    }
}
