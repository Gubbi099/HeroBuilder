package game.model;

import game.Shop;

import game.model.items.Item;

import java.util.Random;

public class Character {
    public Random random = new Random();

    private String name;
    private int health;
    private int maxHealth;
    private int level;
    private int experiencePoints;
    private double gold;
    private char classType;
    private boolean isAlive;

    private final int levelThreshold;

    private int inventorySize;

    public Inventory inventory;

    public Shop shop;

    public Character(String name) {
        this.name = name;
        this.gold = 0;
        this.isAlive = true;
        this.experiencePoints = 0;
        this.level = 1;
        this.health = 100;
        this.maxHealth = 100;
        this.inventorySize = 10;

        this.levelThreshold = 100;

        this.inventory =  new Inventory(this, inventorySize);
        this.shop = new Shop(this);
    }

    // Character methods.
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return this.health;
    }
    public void setHealth(int health) {
        if (health < this.getMaxHealth()){
            if (health > 0) {
                this.health = health;
            } else {
                this.health = 0;
            }
        }
    }

    public void onKill() {
        int defaultXp = 25;
        this.addExperiencePoints(defaultXp);

        this.levelUp();

        System.out.println(this.getName() + " has been rewarded " + defaultXp + "XP.");
    }

    public void onDeath() {
        System.out.println(this.getName() + " has died.");
    }

    public void attack(Character character) {
        int damage = random.nextInt(25);
        character.takeDamage(damage);

        if (damage != 0) {
            if (damage >= 20) {
                System.out.println("CRITICAL HIT!!!");
            }
            System.out.println(this.getName() + " attacks " + character.getName() + "(" + character.getHealth() + "/" + character.getMaxHealth() + ")" + " for " + damage + " damage.");

            // After an enemy has been slain. Run this ->
            if (character.isAlive() && character.getHealth() <= 0) {
                character.onDeath();
                character.kill();
                this.onKill();
                System.out.println(this.getName() + " has slain " + character.getName() + ".");
            }
            return;
        }
        System.out.println("Attack missed!");
    }

    public int getInventorySize() {
        return inventorySize;
    }

    public void setInventorySize(int inventorySize) {
        this.inventorySize = inventorySize;
    }

    public void addHealth(int health) {
        this.setHealth(this.getHealth() + health);
    }

    public void removeHealth(int health) {
        this.setHealth(this.getHealth() - health);
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentLevel() {
        return this.level;
    }
    public void setCurrentLevel(int level) {
        this.level = level;
    }

    public int getExperiencePoints() {
        return this.experiencePoints;
    }
    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints =  experiencePoints;
    }

    public void addExperiencePoints(int experiencePoints) {
        setExperiencePoints(getExperiencePoints() + experiencePoints);
    }

    public double getGold() {
        return this.gold;
    }
    public void setGold(double gold) {
        this.gold = gold;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void setAlive(boolean aliveState) {
        this.isAlive = aliveState;
    }

    public char getClassType() {
        return this.classType;
    }
    public void setClassType(char classType) {
        this.classType = classType;
    }

    public void levelUp() {
        if (this.experiencePoints >= this.levelThreshold) {
            this.setCurrentLevel(this.getCurrentLevel() + 1);
            this.setExperiencePoints(this.experiencePoints - this.levelThreshold);
        }

    }

    public boolean isHealthCritical() {
        if (this.getHealth() <= (this.getMaxHealth() * 0.25)) {
            return true;
        }
        return false;
    }

    public void kill() {
        this.setAlive(false);
        this.setHealth(0);
    }

    public void onTakeDamage() {

    }

    public void takeDamage(int damage) {
        this.setHealth(this.getHealth() - damage);
        this.onTakeDamage();
    }

    public double getHealthPercentage() {
        return ((double) this.getHealth() / this.getMaxHealth()) * 100;
    }

    public void addItem(Item item) {
        this.inventory.addItem(item);
        item.setOwner(this);
        item.init();
    }

    public void printInventory() {
        System.out.println("== " + this.getName() + "'s Inventory " + "(" +  this.inventory.getItems().size() + " item(s)) ==");
        for (Item item : this.inventory.getItems()) {
            System.out.println(" - " + item.getName());
        }
        System.out.println();
    }

    public void printStats() {
        System.out.println("=== CHARACTER STATS ===");
        System.out.println("Name: " + this.getName());
        System.out.println("Class: " + this.getClassType());
        System.out.println("Level: " + this.getCurrentLevel());
        System.out.println("Health: " + this.getHealth()+ "/" + this.getMaxHealth());
        System.out.println("XP: " + this.getExperiencePoints());
        System.out.println("Gold: " + this.getGold());
        System.out.println("Alive: " + this.isAlive());

        System.out.println("");

    }

}
