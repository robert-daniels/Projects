package UnmanagedWork.AlgoPractice;


import java.util.*;

/**
 * very basic practice
 * 
 * Linear search: find a value in the array. 
 * 
 * Worst case: array[-1]
 * #TODO: O(n) complexity
 */

public class LinearSearch {
    
    public static void main(String[] args){


    int[] testArray = {1, 2, 3, 4, 5};
    Scanner scnr = new Scanner(System.in);
    int testCounter = 0;

    int testVariable = scnr.nextInt();

    for (int i : testArray){
        ++testCounter;

        if (i == testVariable){
            System.out.println("Found " + i);
            System.out.println(testCounter);
        }

    }
    
    scnr.close();

    }
}
