package game.model.items;

import game.model.Character;

public class Weapon implements Item {
    public game.model.Character owner;

    private String name;
    private int damage;
    private int durability;
    private boolean isUseAble;
    private double value;

    public Weapon() {
        this.name = "New Weapon";
    }

    public void setOwner (Character owner) {
        this.owner = owner;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public boolean isUseAble() {
        return this.isUseAble;
    }

    public void setUseAble(boolean useAble) {
        this.isUseAble = useAble;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void use() {

    }

    public void onRemove() {

    }

    public void init() {

    }
}
