package game.model.items;

import game.model.Character;

public interface Item{
    public void setOwner(Character owner);
    public String getName();
    public void setName(String name);
    public void init();
    public void use();
    public void onRemove();
    public boolean isUseAble();
    public double getValue();
}
