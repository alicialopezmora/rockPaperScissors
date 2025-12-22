package org.example;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean repeat = true;
        int option;

        System.out.println("Type your name: ");
        String name = scanner.nextLine();

        while(repeat){
            String menu = new StringBuilder("\n###################################\n")
                    .append("Welcome ")
                    .append(name)
                    .append(" to Rock, Paper, Scissors!\n")
                    .append("1. Play Simple Game\n")
                    .append("2. Play Special Game\n")
                    .append("3. Show Rules\n")
                    .append("4. Exit\n")
                    .append("###################################\n")
                    .append("Choose an option:")
                    .toString();

            option = Util.readInt(scanner, menu, "\nInvalid option. Must type an integer");

            switch (option) {
                case 1:
                    SimpleGame.startGame(name);
                    break;
                case 2:
                    SpecialGame.startGame(name);
                    break;
                case 3:
                    System.out.println();
                    Util.readRules("src/main/resources/rules.txt");
                    break;
                case 4:
                    repeat = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 4.");
            }
        }
    }
}