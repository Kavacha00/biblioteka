package bp.biblioteka.entity.store;

import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

@Getter
public abstract class Store implements Cloneable{
    protected UUID id;
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

    @Override
    public Store clone() {
        try {
            return (Store) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public abstract String processOrder();


}
