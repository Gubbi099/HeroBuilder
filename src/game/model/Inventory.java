package game.model;

import game.model.items.Item;

import java.util.ArrayList;

public class Inventory{
        private Character owner;
        private int inventorySize;

        public Inventory(Character owner, int inventorySize) {
            this.owner = owner;
            this.inventorySize = inventorySize;
        }

        ArrayList<Item> item = new ArrayList<>();

        public boolean isInventoryFull() {
            return item.size() >= this.inventorySize;
        }

        public void addItem(Item item) {
            if (!this.isInventoryFull()) {
                this.item.add(item);
            }
        }

        public void removeItem(Item item) {
            item.onRemove();
            this.item.remove(item);
        }

/*        private void removeItemByName(String name) {
            removeItem(this.getItemByName(name));
        }*/

        public ArrayList<Item> getItems() {
        return this.item;
    }

        public Item getItemByName(String name) {
            for (Item Item: getItems()) {
                if (Item.getName().equalsIgnoreCase(name)) {
                    return Item;
                }
            }
            return null;
        }



}
