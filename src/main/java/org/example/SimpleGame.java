package org.example;

import java.util.*;

public class SimpleGame {
    private HashMap<Integer, ArrayList<Integer>> rules;
    private final String[] options = new String[] {"Rock", "Paper", "Scissors"};
    private final Scanner scanner = new Scanner(System.in);

    public HashMap<Integer, ArrayList<Integer>> getRules() {
        return rules;
    }

    public void setRules(HashMap<Integer, ArrayList<Integer>> rules) {
        this.rules = rules;
    }

    public SimpleGame(){
        this.rules = new HashMap<>();
        this.rules.put(0, new ArrayList<>(List.of(2))); // Rock defeats Scissors
        this.rules.put(1, new ArrayList<>(List.of(0)));// Paper defeats Rock
        this.rules.put(2, new ArrayList<>(List.of(1)));// Scissors defeats Paper
    }

    public void startGame(){
        boolean gameWin = false;
        Random rand = new Random();
        int choice = -1;

        do{
            int pcOption = rand.nextInt(options.length);
            String chooseOption = "Choose an option: 1. Rock | 2.Paper | 3.Scissors";

            choice = Util.readInt(scanner, chooseOption, "You must type an integer between 1 and 3\n");

            System.out.println("\nPlayer PC chooses " + options[pcOption] + " while Player 1 chooses " + options[choice-1] + "\n");

            if(pcOption == choice-1){
                System.out.println("It's a tie!\n");
            } else {
                int loser = getRules().get(pcOption).get(0);
                if (choice-1 != loser){
                    System.out.println("You win!\n");
                } else {
                    System.out.println("Player PC wins!\n");
                }
                gameWin = true;
            }

        } while(!gameWin);
    }
}
