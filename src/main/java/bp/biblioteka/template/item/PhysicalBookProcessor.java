package bp.biblioteka.template.item;

import bp.biblioteka.entity.item.Item;

public class PhysicalBookProcessor extends ItemProcessingTemplate{
    @Override
    protected void store(Item item){
        System.out.println("Ustawienie przedmiotu na odpowiednią półkę");
    }
}
