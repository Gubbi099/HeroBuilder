package game.model.items;

public class Potion extends Accessories{
    public Potion() {
        this.setName("Potion");
        this.setWeight(100);
        this.setValue(25);
        this.setUseAble(true);
    }

    public void use() {
        this.owner.addHealth(25);
        this.owner.inventory.removeItem(this);
        System.out.println(owner.getName() + " has used a health potion!");
    }
}
