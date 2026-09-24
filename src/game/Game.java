package game;

import game.model.Enemy;
import game.model.Character;
import game.model.items.Item;

import java.util.Scanner;

/*
        GAME LOOP
 */

public class Game {
        private boolean isActive = true;

        private final Scanner userInput = new Scanner(System.in);

        private StringBuilder stringBuilder = new StringBuilder();

        public Character startCharacter;

        public Enemy startEnemy;

        private String[] commands = {"attack", "use", "shop", "inventory", "stats", "quit"};

        public void onGameEnd() {
                System.out.println("Do you want to start find a new enemy? [yes] [no]");
                switch (userInput.nextLine().toLowerCase()) {
                        case "yes":
                                new Game(startCharacter, new Enemy("Dragon"));
                                break;
                        case "no":
                                System.out.println("Quitting game");
                                this.setActive(false);
                                break;
                }
        }

        public String createCommandString() {
                this.stringBuilder.setLength(0);
                for (String command : commands) {
                        stringBuilder.append("[\033[3m");
                        stringBuilder.append(command);
                        stringBuilder.append("\033[0m] ");
                }
                return stringBuilder.toString();
        }

        public String createItemString() {
                this.stringBuilder.setLength(0);
                for (Item item : startCharacter.inventory.getItems()) {
                        if (item.isUseAble()) {
                                stringBuilder.append("(");
                                stringBuilder.append(item.getName());
                                stringBuilder.append(")");
                                stringBuilder.append(" ");
                        }
                }
                return stringBuilder.toString();
        }


        public Game(Character startCharacter, Enemy startEnemy) {
                this.setStartCharacter(startCharacter);
                this.setStartEnemy(startEnemy);

                String commandString = createCommandString();

                System.out.println("== HeroBuilder ==");
                System.out.println("New game. " + startCharacter.getName() + "(you) against " + startEnemy.getName());



                // Create new game loop
                while(this.isActive()) {

                        // Run this on game end
                        if (!startEnemy.isAlive() || !startCharacter.isAlive()) {
                                onGameEnd();
                                break;
                        }

                        System.out.println();
                        System.out.println(commandString);

                        String command = userInput.nextLine();

                        switch(command.toLowerCase()) {
                                case "attack":
                                        startCharacter.attack(startEnemy);
                                        Utilities.sleep(1);


                                        if (startEnemy.isAlive()) {
                                                System.out.println("Opponents turn...");
                                                Utilities.sleep(1);
                                                startEnemy.attack(startCharacter);
                                        }
                                        break;
                                case "use":
                                        String itemsToUse = createItemString();

                                        System.out.println(itemsToUse);

                                        String inputItem = userInput.nextLine();
                                        Item useItem = startCharacter.inventory.getItemByName(inputItem);

                                        if (useItem != null) {
                                                useItem.use();
                                        } else {
                                                System.out.println("Item not found.");
                                        }
                                        break;
                                case "inventory":
                                        startCharacter.printInventory();
                                        break;
                                case "shop":

                                        // Display shop to user.
                                        startCharacter.shop.displayShop();

                                        System.out.println("Would you like to purchase an item? [Yes] [No]");

                                        if (userInput.nextLine().equalsIgnoreCase("yes")) {
                                                System.out.println("Please enter an item to purchase: ");
                                                String itemToBuy = userInput.nextLine();
                                                startCharacter.shop.buyItemByName(itemToBuy);
                                        }

                                    break;
                                case "stats":
                                        startCharacter.printStats();
                                        break;
                                case "quit":
                                        this.setActive(false);
                                        System.out.println("Quitting game.");
                                        break;
                                default:
                                        System.out.println("Invalid command");
                        }
                }


        }

        public void setActive(boolean active) {
                this.isActive = active;
        }

        public boolean isActive() {
                return this.isActive;
        }


        public void setStartCharacter(Character startCharacter) {
                this.startCharacter = startCharacter;
        }

        public void setStartEnemy(Enemy startEnemy) {
                this.startEnemy = startEnemy;
        }

}
