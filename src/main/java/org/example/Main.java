package org.example;

import java.util.Scanner;

/**
 * The primary menu that allows access to all other programs within the package. Optional, but easy to use.
 * This class was specifically created to provide ease of use when running the programs within this assessment.
 * It is not included for the purpose of grading, but merely quality of life. I developed this class while
 * testing, and decided I may as well leave it in the package in case it's helpful.
 */
public class Main {

    /**
     * The main entry point into the application.
     * @param args Unused.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepGoing = true;
        while (keepGoing) {

            System.out.println("Welcome. Please choose from the following options: \n");
            System.out.println("1. Rock Paper Scissors");
            System.out.println("2. Dog Genetics");
            System.out.println("3. Healthy Hearts");
            System.out.println("4. Summative Sums \n");
            System.out.println("When you have made your choice, please enter the number corresponding to the application you wish to run:");

            try {
                int selection = scanner.nextInt();
                runProgram(selection);
                System.out.println("Program terminated. Enter \"X\" to exit, or anything else to try another program.");
                if (scanner.next().equals("X")) {
                    keepGoing = false;
                }

            } catch (Exception e) {
                System.out.println("An error occurred. Enter \"X\" to exit, or anything else to try another program.");
                //Small bug with this implementation: If the last input was X, it will auto-terminate.
                //This is why the exit character is X and not N; N is the termination character for RockPaperScissors.
                if (scanner.next().equals("X")){
                    keepGoing = false;
                }
            }
        }
    }

    private static void runProgram(int selection){
        if(selection == 1){
            RockPaperScissors.main(null);
        }
        if(selection == 2){
            DogGenetics.main(null);
        }
        if(selection == 3){
            HealthyHearts.main(null);
        }
        if(selection == 4){
            SummativeSums.main(null);
        }
    }

}