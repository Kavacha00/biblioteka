package bp.biblioteka.state.store;

import bp.biblioteka.entity.store.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class OrderStateTest {

    @Test
    void shouldTransitionThroughOrderStates() {
        Order order = new Order();

        assertInstanceOf(NewOrderState.class, order.getState());
        assertEquals("Nowe zamówienie", order.printStatus());

        order.nextState();
        assertInstanceOf(ProcessingOrderState.class, order.getState());
        assertEquals("Zamówienie w trakcie przetwarzania", order.printStatus());

        order.nextState();
        assertInstanceOf(CompletedOrderState.class, order.getState());
        assertEquals("Zamówienie zakończone", order.printStatus());

        order.nextState();
        assertInstanceOf(CompletedOrderState.class, order.getState());
        assertEquals("Zamówienie zakończone", order.printStatus());
    }
}