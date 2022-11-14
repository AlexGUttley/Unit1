package org.example;

import java.util.Random;
import java.util.Scanner;

/**
 * Plays a game of rock paper scissors, using the console for input and output.
 * Games consist of 1-10 rounds, selected by the player at game start.
 * Opponent is a computer who chooses randomly from available moves.
 */
public class RockPaperScissors {

    /**
     * The main entry point into the application.
     * @param args Unused.
     */
    public static void main(String[] args){

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean readyToPlay;

        //'Main Menu' loop: starts up a game using the play method given a number of rounds, and then repeats if needed.
        System.out.println("Welcome to Rock Paper Scissors!");
        do{
            System.out.println("How many rounds would you like to play? (1-10)");
            //try/catch ensures scanner.nextInt() is an integer; if/else ensure that the number is between 1 and 10.
            //This is to avoid printing a user-unintelligible error, and instead explains the error in a human-readable way.
            try{
                int roundsRemaining = scanner.nextInt();
                scanner.nextLine(); //Reads the rest of the line, so that it's out of the queue.
                if (roundsRemaining <= 10 && roundsRemaining > 0){
                    readyToPlay = play(roundsRemaining, random, scanner);
                } else {
                    System.out.println("I'm sorry, but that wasn't a number between 1 and 10 - or if it was, I didn't recognise it.");
                    readyToPlay = false;
                }
            } catch (Exception e) {
                System.out.println("I'm sorry, but that wasn't a number between 1 and 10 - or if it was, I didn't recognise it.");
                readyToPlay = false;
            }
        } while (readyToPlay);
        System.out.println("Thanks for playing!");
    }//end of main

    //Main loop for the game itself: Performs the internal game logic, and communicates it to the player.
    private static boolean play(int roundsRemaining, Random random, Scanner scanner) {
        int wins = 0;
        int losses = 0;
        int draws = 0;

        //Core game loop: Takes input, uses the checkWinner method to calculate who won, and then reports to the player.
        for (int i = 0; i < roundsRemaining; i++) {
            System.out.println("ROUND " + (i+1));
            boolean validMove = false;
            String playerMove;

            //Takes the player's input, and checks it is one of the valid responses. Case-insensitive.
            do {
                System.out.println("Make your choice: [Rock, Paper, Scissors]");
                playerMove = scanner.nextLine().trim();
                //checks move is valid
                if (playerMove.equalsIgnoreCase("rock") ||
                        playerMove.equalsIgnoreCase("paper") ||
                        playerMove.equalsIgnoreCase("scissors")
                ) {
                    validMove = true;
                }
                else {
                    System.out.println("Sorry, that wasn't a valid move.");
                }

            } while (!validMove);
            String computerMove = moveGenerator(random);

            //Prints out the state and outcome of the round.
            System.out.println("You played " + playerMove + ", and the computer played " + computerMove);
            int whoWon = checkWinner(playerMove, computerMove);
            if (whoWon == 1){
                System.out.println("You win this round!");
                wins++;
            } else if (whoWon == -1) {
                System.out.println("The computer wins this round.");
                losses++;
            } else {
                System.out.println("It's a draw!");
                draws++;
            }
            System.out.println("\n");
        }

        //End of game wrap-up: Report scores and declare a winner.
        System.out.println("The game is over!");
        System.out.println("The computer won " + losses + " times, and you won " + wins + " times! Also, you drew " + draws + " times.");
        if(losses < wins){
            System.out.println("You win! Congratulations!");
        } else if (wins < losses) {
            System.out.println("The computer wins this time. Sorry!");
        } else {
            System.out.println("Looks like it's a draw!");
        }

        //Ask the player if they'd like to play again. Will attempt multiple times, and if patience runs out, will assume no.
        int patience = 3;
        while (patience > 0){
            System.out.println("Would you like to play again? [Yes, No]");
            String response = scanner.nextLine().trim();
            if(response.equalsIgnoreCase("Yes")){
                return true;
            } else if (response.equalsIgnoreCase("No")){
                return false;
            }
            System.out.println("I'm sorry, I didn't understand that.");
            patience--;
        }
        System.out.println("No valid response detected in 3 attempts. Program will now terminate.");
        return false;
    }//end of play


    //A simple class to generate a random valid move string.
    private static String moveGenerator(Random random) {
        int move = random.nextInt(3);
        if (move == 0){
            return "Rock";
        } else if (move == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    //Returns an int representing the state of the game. 1 = a win, 0 = a draw, and -1 = a loss.
    private static int checkWinner(String playerMove, String computerMove) {

        int playerWon;

        if (playerMove.equalsIgnoreCase("rock") && computerMove.equalsIgnoreCase("scissors") ||
            playerMove.equalsIgnoreCase("scissors") && computerMove.equalsIgnoreCase("paper") ||
            playerMove.equalsIgnoreCase("paper") && computerMove.equalsIgnoreCase("rock")
        ){

            playerWon = 1;

        } else if (
            playerMove.equalsIgnoreCase("paper") && computerMove.equalsIgnoreCase("scissors") ||
            playerMove.equalsIgnoreCase("rock") && computerMove.equalsIgnoreCase("paper") ||
            playerMove.equalsIgnoreCase("scissors") && computerMove.equalsIgnoreCase("rock")
        ){

            playerWon = -1;

        } else {

            playerWon = 0;

        }
        return playerWon;
    }

}//end of class
