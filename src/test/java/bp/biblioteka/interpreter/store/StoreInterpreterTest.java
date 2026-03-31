package bp.biblioteka.interpreter.store;

import bp.biblioteka.entity.item.Book;
import bp.biblioteka.bridge.item.DigitalFormat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreInterpreterTest {

    @Test
    void shouldInterpretAuthorExpression() {
        Book book = new Book("Adam Mickiewicz", "Pan Tadeusz", new DigitalFormat());
        Expression expr = new AuthorExpression("Adam Mickiewicz");

        assertTrue(expr.interpret(book));
    }

    @Test
    void shouldInterpretTitleExpression() {
        Book book = new Book("Stanisław Lem", "Solaris", new DigitalFormat());
        Expression expr = new TitleExpression("Solaris");

        assertTrue(expr.interpret(book));
    }

    @Test
    void interpreterShouldParseAuthorQuery() {
        StoreQueryInterpreter interpreter = new StoreQueryInterpreter();
        Expression expr = interpreter.parse("AUTHOR \"Henryk Sienkiewicz\"");

        Book book = new Book("Henryk Sienkiewicz", "Quo Vadis", new DigitalFormat());

        assertTrue(expr.interpret(book));
    }

    @Test
    void interpreterShouldParseTitleQuery() {
        StoreQueryInterpreter interpreter = new StoreQueryInterpreter();
        Expression expr = interpreter.parse("TITLE \"Krzyżacy\"");

        Book book = new Book("Henryk Sienkiewicz", "Krzyżacy", new DigitalFormat());

        assertTrue(expr.interpret(book));
    }

    @Test
    void interpreterShouldIgnoreCase() {
        StoreQueryInterpreter interpreter = new StoreQueryInterpreter();
        Expression expr = interpreter.parse("TITLE \"solaris\"");

        Book book = new Book("Lem", "Solaris", new DigitalFormat());

        assertTrue(expr.interpret(book));
    }

    @Test
    void shouldThrowExceptionForUnknownCommand() {
        StoreQueryInterpreter interpreter = new StoreQueryInterpreter();

        assertThrows(IllegalArgumentException.class, () ->
                interpreter.parse("PUBLISHER \"ABC\"")
        );
    }
}