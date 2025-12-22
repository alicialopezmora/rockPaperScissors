package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Util{
    public static int readInt(Scanner sc, String message, String errorMessage){
        int readedNumber = 0;
        boolean repeatQuestion = false;

        do {
            repeatQuestion = false;
            try{
                System.out.println(message);
                readedNumber = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                repeatQuestion = true;
                System.out.println(errorMessage);
            }
        }while (repeatQuestion);

        return readedNumber;
    }

    public static void readRules(String file){
        try(BufferedReader br = new BufferedReader (new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }

}
