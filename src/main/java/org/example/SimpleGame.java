package org.example;

import java.util.*;

import static java.util.Map.entry;

public class SimpleGame {
    protected HashMap<Integer, ArrayList<Integer>> rules;
    protected final ArrayList<String> options;
    protected static Scanner scanner = new Scanner(System.in);
    protected HashMap<String, String> results;

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

        results = new HashMap<>(Map.ofEntries(
                entry("0-2", "crushes"),
                entry("1-0", "covers"),
                entry("2-1", "cuts")
        ));
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
        int userChoice = choice - 1;
        System.out.println("\nPC chooses " + getOptions().get(pcOption) + " while " + name + " chooses " + getOptions().get(userChoice));

        if(pcOption == userChoice){
            System.out.println("It's a tie!\n"); // tie so the game continuous
            return false;
        } else {
            List<Integer> posibleLosers = getRules().get(pcOption);
            if (posibleLosers.contains(userChoice)){ // if the choice is on the loser list of the option
                System.out.print("You lost! -> ");
                showResult(pcOption, userChoice);
            } else {
                System.out.print("You win! -> ");
                showResult(userChoice, pcOption);
            }
            return true;
        }
    }

    private void showResult(int winner, int loser) {
        String key = winner + "-" + loser;
        String result = results.get(key);

        String[] emojis = {"\u270A", "\u270B", "\u270C", "\uD83E\uDD8E", "\uD83D\uDD96"};

        System.out.println(options.get(winner) + " (" + emojis[winner] + ") " + result + " " + options.get(loser));
    }

}
