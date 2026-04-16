package bp.biblioteka.strategy.user;

import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserNotificationStrategyTest {

    @Test
    void shouldUseEmailStrategyByDefault() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        assertEquals("EMAIL", employee.getNotificationStrategyName());
    }

    @Test
    void shouldSwitchToSmsStrategy() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        employee.setNotificationStrategy(new SmsNotificationStrategy());

        assertEquals("SMS", employee.getNotificationStrategyName());
    }

    @Test
    void shouldSwitchToPushStrategy() {
        Employee employee = new Employee("John Doe", "john@doe.com", "John's Login", "John's Password");

        employee.setNotificationStrategy(new PushNotificationStrategy());

        assertEquals("PUSH", employee.getNotificationStrategyName());
    }

    @Test
    void shouldSendEmailNotification() {
        Customer customer = new Customer("John Doe", "john@doe.com", "John's Login", "John's Password");

        String result = customer.notify("Your order has been placed.");

        assertEquals("Email sent to [john@doe.com]: Your order has been placed.", result);
    }

    @Test
    void shouldSendSmsNotification() {
        Customer customer = new Customer("John Doe", "john@doe.com", "John's Login", "John's Password");

        customer.setNotificationStrategy(new SmsNotificationStrategy());
        String result = customer.notify("Your order has been shipped.");

        assertEquals("SMS sent to [john@doe.com]: Your order has been shipped.", result);
    }

    @Test
    void shouldSendPushNotification() {
        Customer customer = new Customer("John Doe", "john@doe.com", "John's Login", "John's Password");

        customer.setNotificationStrategy(new PushNotificationStrategy());
        String result = customer.notify("Your order has been delivered.");

        assertEquals("Push notification sent to [john@doe.com]: Your order has been delivered.", result);
    }

    @Test
    void shouldUseUserEmailAsRecipient() {
        Customer customer = new Customer("John Doe", "john@doe.com", "John's Login", "John's Password");

        String result = customer.notify("Test message.");

        assertTrue(result.contains("john@doe.com"));
    }

    @Test
    void shouldIncludeMessageInNotification() {
        Customer customer = new Customer("John Doe", "john@doe.com", "John's Login", "John's Password");

        String result = customer.notify("Test message.");

        assertTrue(result.contains("Test message."));
    }

    @Test
    void shouldSwitchStrategyAtRuntime() {
        Customer customer = new Customer("John Doe", "john@doe.com", "John's Login", "John's Password");

        String firstResult = customer.notify("First message.");

        customer.setNotificationStrategy(new SmsNotificationStrategy());
        String secondResult = customer.notify("Second message.");

        assertTrue(firstResult.startsWith("Email"));
        assertTrue(secondResult.startsWith("SMS"));
    }

    @Test
    void shouldApplyStrategyIndependentlyPerUser() {
        Customer customer = new Customer("John Doe", "john@doe.com", "John's Login", "John's Password");
        Employee employee = new Employee("Jane Doe", "jane@doe.com", "Jane's Login", "Jane's Password");

        customer.setNotificationStrategy(new PushNotificationStrategy());

        assertEquals("PUSH", customer.getNotificationStrategyName());
        assertEquals("EMAIL", employee.getNotificationStrategyName());
    }
}