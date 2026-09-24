package game.model.items;

import game.model.Character;

public class Accessories implements Item{
    public game.model.Character owner;

    private String name;
    private int weight;
    private double value;
    private boolean isUseAble;

    public Accessories() {
        this.name = "New Item";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setOwner(Character owner) {
        this.owner = owner;
    }

    public boolean isUseAble() {
        return this.isUseAble;
    }

    public void setUseAble(boolean useAble) {
        this.isUseAble = useAble;
    }

    public void use() {

    }

    public void onRemove() {

    }

    public void init() {

    }
}
