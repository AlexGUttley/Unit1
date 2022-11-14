package org.example;

import java.util.Random;
import java.util.Scanner;

/**
 * Takes a name as input from the console, and makes up random genetic information, then outputs it to console.
 * Extra care is taken to ensure no breed is listed as 0% present, to ensure verisimilitude.
 */
public class DogGenetics {

    /**
     * The main entry point into the application.
     * @param args Unused.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[] breedPercentages = new int[5];
        //currentLimit is initialised low and raised to ensure that the cap is not reached prematurely.
        int currentLimit = (105 - (5 * breedPercentages.length));

        //for the first 4 breeds, generates an int between 1 and the current limit.
        //then adds it to the percentages, and removes that value from the maximum remaining available.
        //lastly, increments the current limit by 5, so that the available percentage is never 0%.
        for (int i = 0; i < (breedPercentages.length-1); i++){
            int randInt = random.nextInt(currentLimit-1);
            breedPercentages[i] = randInt+1;
            currentLimit -= breedPercentages[i];
            currentLimit += 5;
        }
        //Once 4 breeds have been totaled, set the final
        breedPercentages[breedPercentages.length-1] = currentLimit;

        System.out.print("What is your dog's name? ");
        String name = scanner.nextLine();
        System.out.println("\n" + "Well then, I have this highly reliable report on " + name + "'s prestigious background right here. \n");

        //Until this point in the program, the amount of breeds may be set to any value between 1 and 19 without issue.
        //However, the following print statements are hard-coded for 5 breeds.
        //This meets the spec, but if the amount of breeds is to be changed, the below must be made value-independent too.
        System.out.println(name + " is: \n");
        System.out.println(breedPercentages[0] + "% St. Bernard");
        System.out.println(breedPercentages[1] + "% Chihuahua");
        System.out.println(breedPercentages[2] + "% Dramatic RedNosed Asian Pug");
        System.out.println(breedPercentages[3] + "% Common Cur");
        System.out.println(breedPercentages[4] + "% King Doberman \n");
        System.out.println("Wow, that's QUITE the dog!");

    }

}