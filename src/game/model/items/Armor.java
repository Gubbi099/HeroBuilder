package game.model.items;

import game.model.Character;

public class Armor implements Item {
    public game.model.Character owner;

    private String name;
    private int defence;
    private int durability;
    private boolean isUseAble;
    private double value;

    public Armor() {
        this.name = "New Armor";
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

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
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

    public void use() {
    }

    public void init() {
    }

    public void onRemove() {
    }
}
