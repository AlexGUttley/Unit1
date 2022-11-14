package org.example;


/**
 * Instances, sums, and prints three arbitrary arrays to the console.
 */
public class SummativeSums {

    /**
     * The main entry point into the application.
     * @param args Unused.
     */
    public static void main(String[] args){
        //Initialises the arrays
        int[] firstArray = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] secondArray = { 999, -60, -77, 14, 160, 301 };
        int[] thirdArray = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99 };

        //Records the summed value of the arrays.
        int firstSum = sum(firstArray);
        int secondSum = sum(secondArray);
        int thirdSum = sum(thirdArray);

        //Prints the summed value of the arrays.
        System.out.println("#1 Array Sum: " + firstSum);
        System.out.println("#2 Array Sum: " + secondSum);
        System.out.println("#3 Array Sum: " + thirdSum);

    }

    //The static method requested in the brief.
    private static int sum(int[] input) {
        int sum = 0;
        for (int value : input){
            sum += value;
        }
        return sum;
    }
}
