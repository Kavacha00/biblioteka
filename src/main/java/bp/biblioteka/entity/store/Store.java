package bp.biblioteka.entity.store;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class Store {
    private UUID id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public Store(String name, String email, String address, String phoneNumber) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public abstract String processOrder();

}
