package bp.biblioteka.iterator.user;

import bp.biblioteka.entity.user.Customer;
import bp.biblioteka.entity.user.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Tydzień 5, Wzorzec Iterator 2
//Iterator z kolekcji userów zwraca tylko customerów

public class UserCollection {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public Iterator<Customer> customerIterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                while (index < users.size()) {
                    if (users.get(index) instanceof Customer) return true;
                    index++;
                }
                return false;
            }

            @Override
            public Customer next() {
                Customer customer = (Customer) users.get(index);
                index++;
                return customer;
            }
        };
    }
}
//Koniec, Tydzień 5, Wzorzec Iterator 2