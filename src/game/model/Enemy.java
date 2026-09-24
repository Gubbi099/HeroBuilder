package game.model;

import game.Utilities;

public class Enemy extends Character{

    private static String[] possibleNames = {"Goblin", "Dragon", "Evil Wizard", "Orc", "Mogul", "Zombie"};
    private static String[] enemyTaunts = {"&eName& is stirring up a ferocious attack!", "&eName& has something special prepared for you", "Is it a bird? is it a plane? no it's &eName&", "Can you guess what &eName& is cooking?"};

    private static String getTaunt(Enemy enemy) {
        return Utilities.getRandom(enemyTaunts).replace("&eName&", enemy.getName());
    }


    public Enemy(String name) {
        super(name);

        // -- Init "Enemy"
        this.setHealth(50);
        this.setMaxHealth(50);
        this.setClassType('E');

        // Set random name for each enemy
        this.setName(Utilities.getRandom(possibleNames));
    }

    public void attack(Character character) {
        System.out.println(getTaunt(this));
        Utilities.sleep(2);
        int damage = random.nextInt(25);
        character.takeDamage(damage);

        if (damage != 0) {
            if (damage >= 20) {
                System.out.println("CRITICAL HIT");
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

    public void onDeath() {

    }
}
