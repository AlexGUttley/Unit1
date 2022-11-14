package org.example;

import java.util.Scanner;

/**
 * Takes an age as input from the console, and outputs metrics related to heart rate to the console.
 */
public class HealthyHearts {

    /**
     * The main entry point into the application.
     * @param args Unused.
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is your age? ");
        try{
            int age = scanner.nextInt();
            //if statement used as sanity check, to ensure age is within reasonable bound
            if(age < 0 || age > 200){
                System.out.println("No, it's not.");
            } else  if (scanner.nextLine().trim().equalsIgnoreCase("months")) {
                //small additional check to ensure that ages in months are not erroneously accepted.
                System.out.println("Sorry, only ages in years are accepted.");
            } else {
                int maxHeartRate = 220 - age;
                //lots of type conversions here. Int > Double > Long > Int. Be careful when editing.
                int lowerBound = (int) Math.round((maxHeartRate * 50.0)/100);
                int upperBound = (int) Math.round((maxHeartRate * 85.0)/100);

                System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute");
                System.out.println("Your target HR zone is " + lowerBound + " - " + upperBound + " beats per minute");
            }
        } catch (Exception e){
            //Should only happen when input is not an integer.
            System.out.println("I'm sorry, I didn't quite understand that. Goodbye!");
        }
    }
}
