import java.util.*;

/**
 * Basic Array Practice, 6.13 Lab: People's weight.
 * 
 * Prompt for 5 numbers, store in array of doubles, output array's numbers on 1 line, followed by space.
 * Perform other basic array looping items
 */

 public class PeopleWeight{

    public static void main(String[] args){

        double[] inputArray = new double[5];
        Scanner scnr = new Scanner(System.in);

        for (int i = 0; i < 5; ++i){
            System.out.println("Enter weight " + (i + 1) + ": ");
            inputArray[i] = scnr.nextDouble();
        }

        for (double i : inputArray){
            System.out.print(i);
            System.out.print(" ");
        }

        System.out.println("");

    }
 }