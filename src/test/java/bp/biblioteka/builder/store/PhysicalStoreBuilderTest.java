package bp.biblioteka.builder.store;

import bp.biblioteka.entity.store.PhysicalStore;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class PhysicalStoreBuilderTest {

    @Test
    void shouldCreatePhysicalStoreUsingPhysicalStoreBuilder() {
        PhysicalStoreBuilder builder = new PhysicalStoreBuilder();

        var physicalStore = builder
                .name("Physical Store")
                .email("store@example.com")
                .address("123 Main St")
                .phoneNumber("123-456-7890")
                .build();

        assertInstanceOf(PhysicalStore.class, physicalStore);
    }

    @Test
    void shouldCreatePhysicalStoreWithCorrectFields() {
        PhysicalStoreBuilder builder = new PhysicalStoreBuilder();

        var physicalStore = builder
                .name("Physical Store")
                .email("store@example.com")
                .address("123 Main St")
                .phoneNumber("123-456-7890")
                .build();
        assertEquals("Physical Store", physicalStore.getName());
        assertEquals("store@example.com", physicalStore.getEmail());
        assertEquals("123 Main St", physicalStore.getAddress());
        assertEquals("123-456-7890", physicalStore.getPhoneNumber());
    }

    @Test
    void shouldCreatePhysicalStoreWithoutPhoneNumber() {
        PhysicalStoreBuilder builder = new PhysicalStoreBuilder();

        var physicalStore = builder
                .name("Physical Store")
                .email("store@example.com")
                .address("123 Main St")
                .build();
        assertNull(physicalStore.getPhoneNumber());
    }

    @Test
    void shouldClearFieldsAfterCallingReset() throws Exception {
        PhysicalStoreBuilder builder = new PhysicalStoreBuilder();
        Field field  = PhysicalStoreBuilder.class.getDeclaredField("name");
        field.setAccessible(true);

        builder.name("Physical Store");

        String fieldValueBeforeReset = (String) field.get(builder);

        assertEquals("Physical Store", fieldValueBeforeReset);

        builder.reset();

        String fieldValueAfterReset = (String) field.get(builder);

        assertNull(fieldValueAfterReset);
    }

    @Test
    void shouldClearFieldsAfterBuilding() throws Exception {
        PhysicalStoreBuilder builder = new PhysicalStoreBuilder();
        Field field  = PhysicalStoreBuilder.class.getDeclaredField("name");
        field.setAccessible(true);

        builder.name("Physical Store");

        String fieldValueBeforeBuild = (String) field.get(builder);

        assertEquals("Physical Store", fieldValueBeforeBuild);

        builder.build();

        String fieldValueAfterBuild = (String) field.get(builder);

        assertNull(fieldValueAfterBuild);
    }
}
