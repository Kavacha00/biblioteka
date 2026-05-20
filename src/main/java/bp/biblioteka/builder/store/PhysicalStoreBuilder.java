package bp.biblioteka.builder.store;


import bp.biblioteka.entity.store.PhysicalStore;

//Tydzień 2, Wzorzec Builder 1,
// Wzorzec Builder (Budowniczy) pozwala na tworzenie skomplikowanych obiektów (PhysicalStore) krok po kroku.
// Umożliwia konfigurację obiektu za pomocą płynnego interfejsu (fluent interface), eliminując potrzebę
// tworzenia wielu tzw. "teleskopowych konstruktorów" z różnymi kombinacjami parametrów.

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

//Koniec, Tydzień 2, Wzorzec Builder 1
