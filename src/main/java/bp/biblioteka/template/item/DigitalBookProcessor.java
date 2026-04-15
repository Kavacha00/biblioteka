package bp.biblioteka.template.item;

import bp.biblioteka.entity.item.Item;

public class DigitalBookProcessor extends ItemProcessingTemplate {
    @Override
    protected void store(Item item){
        System.out.println("Dodanie pliku na serwer");
    }
}
