package org.example;

import java.util.*;

public class SimpleGame {
    protected HashMap<Integer, ArrayList<Integer>> rules;
    protected final ArrayList<String> options;
    protected static Scanner scanner = new Scanner(System.in);

    public HashMap<Integer, ArrayList<Integer>> getRules() {
        return rules;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public SimpleGame(){
        this.rules = new HashMap<>();
        this.rules.put(0, new ArrayList<>(List.of(2))); // Rock defeats Scissors
        this.rules.put(1, new ArrayList<>(List.of(0))); // Paper defeats Rock
        this.rules.put(2, new ArrayList<>(List.of(1))); // Scissors defeats Paper
        this.options = new ArrayList<>(List.of("Rock", "Paper", "Scissors"));
    }

    public static void startGame(String name){
        SimpleGame game = new SimpleGame();
        boolean gameWin = false;
        Random rand = new Random();
        int choice = -1;

        do{
            int pcOption = rand.nextInt(game.getOptions().size());
            String chooseOption = "\nChoose an option: 1. Rock | 2.Paper | 3.Scissors";

            choice = Util.readInt(scanner, chooseOption, "\nInvalid option. You must type an integer between 1 and 3\n");

            gameWin = game.performGame(pcOption, choice, name);

        } while(!gameWin);
    }

    public boolean performGame(int pcOption, int choice, String name) {
        System.out.println("\nPC chooses " + getOptions().get(pcOption) + " while " + name + " chooses " + getOptions().get(choice-1) + "\n");

        if(pcOption == choice-1){
            System.out.println("It's a tie!\n"); // tie so the game continuous
            return false;
        } else {
            List<Integer> posibleLosers = getRules().get(pcOption);
            if (posibleLosers.contains(choice-1)){ // if the choice is on the loser list of the option
                System.out.println("You lost!\n");
            } else {
                System.out.println("You win!\n");
            }
            return true;
        }
    }

}
