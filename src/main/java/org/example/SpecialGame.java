package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpecialGame extends SimpleGame {
    public SpecialGame() {
        super();
        this.rules.get(0).add(3);
        this.rules.get(1).add(4);
        this.rules.get(2).add(3);
        this.rules.put(3, new ArrayList<>(List.of(4, 1))); // Rock defeats Scissors
        this.rules.put(4, new ArrayList<>(List.of(2, 0)));// Paper defeats Rock
        this.options.add("Lizard");
        this.options.add("Spock");
    }

    @Override
    public void startGame() {
        boolean gameWin = false;
        Random rand = new Random();
        int choice = -1;

        do{
            int pcOption = rand.nextInt(options.size());
            String chooseOption = "Choose an option: 1. Rock | 2.Paper | 3.Scissors | 4.Lizard | 5.Spock";

            choice = Util.readInt(scanner, chooseOption, "You must type an integer between 1 and 5\n");

            gameWin = performGame(pcOption, choice);

        } while(!gameWin);
    }
}
