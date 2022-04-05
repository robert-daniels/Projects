package UnmanagedWork.AlgoPractice;

import java.util.*;

/**
 * More practice, see original for docstrings
 */


public class BinarySearch3 {
    
    public static void main(String[] args){

        Scanner scnr = new Scanner(System.in);
        int userInt = scnr.nextInt(); // yes, will only take an int

        int[] testArr = {1, 2, 3, 4, 5};
        int lowIndex = 0;
        int highIndex = testArr.length - 1;
        int midIndex;

        while (highIndex >= lowIndex){  // remember >=
            midIndex = (highIndex + lowIndex) / 2;
            
            if (testArr[midIndex] > userInt){
                highIndex = midIndex - 1;
            }
            else if (testArr[midIndex] < userInt){
                lowIndex = midIndex + 1;
            }
            else if (testArr[midIndex] == userInt){
                System.out.printf("Found %d at index %d. Goodbye", userInt, midIndex);
                System.exit(0);
            }
        }

        System.out.print(-1);
    }
}
