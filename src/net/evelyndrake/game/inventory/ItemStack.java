package net.evelyndrake.game.inventory;

public class ItemStack {

    Item item;
    int quantity = 0;
    boolean infinite = false;

    public ItemStack(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public ItemStack(Item item, int quantity, boolean infinite) {
        this.item = item;
        this.quantity = quantity;
        this.infinite = infinite;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void changeQuantity(int x) {
        quantity += x;
    }

    public boolean sameItem(ItemStack comp) {
        return comp.getItem().getName().equals(item.getName());
    }

    @Override
    public String toString() {
        String string = item.getName();
        if (!infinite) {
            string += " x" + quantity;
        }
        return string;
    }

}
