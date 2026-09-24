package game.model;

import game.model.items.LeatherCoat;
import game.model.items.Potion;
import game.model.items.Sword;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name);

        this.setHealth(125);
        this.setMaxHealth(125);
        this.setGold(1000);
        this.setInventorySize(5);

        this.addItem(new Potion());
        this.addItem(new Sword());
        this.addItem(new LeatherCoat());
    }


}
