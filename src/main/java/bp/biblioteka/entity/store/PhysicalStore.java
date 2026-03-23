package bp.biblioteka.entity.store;


import bp.biblioteka.entity.item.Book;

import java.util.UUID;

public class PhysicalStore extends Store  {

    public PhysicalStore(String name, String email, String address, String phoneNumber) {
        super(name, email, address, phoneNumber);
    }

    @Override
    public String processOrder() {
        return "Processing order in physical store";
    }
}
