package bp.biblioteka.iterator.item;

import bp.biblioteka.entity.item.Item;

import java.util.ArrayList;
import java.util.List;

//Tydzień 5, Wzorzec Iterator 3
//Iterator przechodzi po książkach
//danego autora
public class ItemCollectionImpl implements ItemCollection {
    private List<Item> items;
    public ItemCollectionImpl() {
        items = new ArrayList<>();
    }

    @Override
    public void addItem(Item item) {
        this.items.add(item);
    }

    @Override
    public void removeItem(Item item) {
        this.items.remove(item);
    }

    @Override
    public ItemIterator itemAuthorIterator(String author) {
        return new ItemAuthorIteratorImpl(author, this.items);
    }

    private class ItemAuthorIteratorImpl implements ItemIterator {
        private String author;
        private List<Item> items;
        private int position;
        public ItemAuthorIteratorImpl(String author, List<Item> items) {
            this.author = author;
            this.items = items;
        }

        @Override
        public boolean hasNext() {
            while(position < items.size()) {
                Item item = items.get(position);
                if(item.getAuthor().equals(author))
                    return true;
                position++;
            }
            return false;
        }

        @Override
        public Item next() {
            Item item = items.get(position);
            position++;
            return item;
        }

        @Override
        public void reset() {
            position = 0;
        }
    }
}
//Koniec, Tydzień 5, Wzorzec Iterator 3