import game.Game;
import game.model.Character;
import game.model.Enemy;
import game.model.Warrior;

import java.util.Scanner;



public class Herobuilder {

    public static void main(String[] args) {
        System.out.println("Please enter your user name: ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();


        Character john = new Warrior(userName);

        Enemy ib = new Enemy("Goblin");

        Game newGame = new Game(john, ib);
    }

}
