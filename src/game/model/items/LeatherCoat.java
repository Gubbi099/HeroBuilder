package game.model.items;

public class LeatherCoat extends Armor{
    public LeatherCoat() {
        this.setName("Leather Coat");
        this.setDefence(20);
        this.setDurability(100);
    }

    public void init() {
        this.owner.addHealth(this.getDefence());
    }

    public void onRemove() {
        this.owner.removeHealth(this.getDefence());
    }

}
