package org.example;

import java.util.*;

public class SimpleGame {
    protected HashMap<Integer, ArrayList<Integer>> rules;
    protected final ArrayList<String> options;
    protected final Scanner scanner = new Scanner(System.in);

    public HashMap<Integer, ArrayList<Integer>> getRules() {
        return rules;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public SimpleGame(){
        this.rules = new HashMap<>();
        this.rules.put(0, new ArrayList<>(List.of(2))); // Rock defeats Scissors
        this.rules.put(1, new ArrayList<>(List.of(0)));// Paper defeats Rock
        this.rules.put(2, new ArrayList<>(List.of(1)));// Scissors defeats Paper
        this.options = new ArrayList<>(List.of("Rock", "Paper", "Scissors"));
    }

    public void startGame(){
        boolean gameWin = false;
        Random rand = new Random();
        int choice = -1;

        do{
            int pcOption = rand.nextInt(options.size());
            String chooseOption = "Choose an option: 1. Rock | 2.Paper | 3.Scissors";

            choice = Util.readInt(scanner, chooseOption, "You must type an integer between 1 and 3\n");

            gameWin = performGame(pcOption, choice);

        } while(!gameWin);
    }

    public boolean performGame(int pcOption, int choice) {
        System.out.println("\nPlayer PC chooses " + getOptions().get(pcOption) + " while Player 1 chooses " + getOptions().get(choice-1) + "\n");

        if(pcOption == choice-1){
            System.out.println("It's a tie!\n");
            return false;
        } else {
            int loser = getRules().get(pcOption).get(0);
            if (choice-1 != loser){
                System.out.println("You win!\n");
            } else {
                System.out.println("Player PC wins!\n");
            }
            return true;
        }
    }

}
