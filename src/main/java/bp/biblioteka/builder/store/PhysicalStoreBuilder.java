package bp.biblioteka.builder.store;


import bp.biblioteka.entity.store.PhysicalStore;

public class PhysicalStoreBuilder {
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public void reset() {
        this.name = null;
        this.email = null;
        this.address = null;
        this.phoneNumber = null;
    }

    public PhysicalStoreBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PhysicalStoreBuilder email(String email) {
        this.email = email;
        return this;
    }

    public PhysicalStoreBuilder address(String address) {
        this.address = address;
        return this;
    }

    public PhysicalStoreBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public PhysicalStore build() {
        var storeName = this.name;
        var storeEmail = this.email;
        var storeAddress = this.address;
        var storePhoneNumber = this.phoneNumber;

        this.reset();
        return new PhysicalStore(storeName, storeEmail, storeAddress, storePhoneNumber);
    }
}
