package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpecialGame extends SimpleGame {
    public SpecialGame() {
        super();
        this.rules.get(0).add(3); // Rock crushes Lizards
        this.rules.get(1).add(4); // Paper disproves Spock
        this.rules.get(2).add(3); // Scissors decapitate Lizard

        this.rules.put(3, new ArrayList<>(List.of(4, 1))); // Lizards defeat Spock and Paper
        this.rules.put(4, new ArrayList<>(List.of(2, 0))); // Spock defeats Scissors and Rock

        this.options.add("Lizard");
        this.options.add("Spock");

        this.results.put("0-3", "crushes");
        this.results.put("1-4", "disproves");
        this.results.put("2-3", "decapitates");
        this.results.put("3-4", "poisons");
        this.results.put("3-1", "eats");
        this.results.put("4-2", "smashes");
        this.results.put("4-0", "vaporizes");
    }

    public static void startGame(String name) {
        SpecialGame game = new SpecialGame();
        boolean gameWin = false;
        Random rand = new Random();
        int choice = -1;

        do{
            int pcOption = rand.nextInt(game.getOptions().size());
            String chooseOption = "\nChoose an option: 1. Rock | 2.Paper | 3.Scissors | 4.Lizard | 5.Spock";

            choice = Util.readInt(scanner, chooseOption, "\nInvalid option. You must type an integer between 1 and 5\n");

            gameWin = game.performGame(pcOption, choice, name);

        } while(!gameWin);
    }
}
