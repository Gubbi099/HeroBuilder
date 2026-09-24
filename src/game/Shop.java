package game;


import game.model.items.Item;
import game.model.items.Potion;
import game.model.items.Sword;
import game.model.Character;

public class Shop {

    private Character owner;
    private Item[] itemsForSale;

    public Shop(Character character) {
        this.owner = character;
        this.itemsForSale = new Item[]{new Potion(), new Sword()};
    }

    public void displayShop() {
        System.out.println("=== ITEM SHOP ===");
        System.out.println("Name: " + this.owner.getName());
        System.out.println("Wallet: " + this.owner.getGold());
        System.out.println();

        System.out.println("=== ITEMS FOR SALE ===");
        for (Item item : getItems()) {
            System.out.println("[" + item.getName() + "] " + "Price: " + item.getValue() + "G");
        }
    }

    public Item[] getItems() {
        return itemsForSale;
    }

    public Item getItemByName(String name) {
        for (Item item : itemsForSale) {
            if (item.getName().equalsIgnoreCase(name)) {
               return item;
            }
        }
        return null;
    }

    public void buyItem(Item item) {
        if (this.owner.getGold() >= item.getValue()) {
            this.owner.addItem(item);
            this.owner.setGold(owner.getGold() - item.getValue());

            System.out.println(owner.getName() + " has purchased " + item.getName() + " for " + item.getValue() + " Gold");
            return;
        }
        System.out.println("Not enough gold!");
    }

    public void buyItemByName(String name) {
        buyItem(getItemByName(name));
    }






}
