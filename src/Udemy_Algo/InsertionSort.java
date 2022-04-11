package Udemy_Algo;

import java.util.*;

public class InsertionSort {
    
    public static void main(String[] args){
        /**
         * Insertion Sort
         * 
         * In-place algorithm
         * O(n2) time complexity - quadratic
         * 
         * Stable Algorithm 
         * 
         * Theory: array is partitioned into sorted and unsorted. At start consider the sorted to be 
         * array[0]. (An array of one element is automatically sorted.) 
         * 
         * Take the lowest indexed value of unsorted and compare it to the largest indexed value of sorted. 
         * If it is greater than, the value is already in its correct space. Assign its index the highest index
         * in the sorted array and increase the starting index of unsorted. 
         * 
         * If it is less than, traverse the sorted array decrementing by one until there is a value that is less than
         * the test value. each traversal down, "push" the sorted value to the next highest index up as you're moving down.  
         * 
         * Think of picking up a stack of papers. You just start with the top paper's last name "Smith." Then if the one after than is 
         * "Rodgers", you put it ahead of Smith. And so on. 
         * 
         * 
         */

         int[] testArray = {20, 35, -15, 7, 55, 1, -22};

         int unsortedIndex; // not strictly necessary as it will be sorted + 1 until the end is reached, but better to be explicit
         int elementToInsert; 


         // loop through unsorted portion

         for ( unsortedIndex = 1; unsortedIndex < testArray.length; ++unsortedIndex ){
            elementToInsert = testArray[unsortedIndex];

            int i; // declare outside of loop to make it not transient

            // while we're not at the start of the sorted array AND the next value is larger than the testValue, alter the i value
            for (i = unsortedIndex; i > 0 && (testArray[i - 1] > elementToInsert); i--){
                testArray[i] = testArray[i-1];
            }

            // once the for loop exits, the i value is = to the index the value should be inserted into. 

            testArray[i] = elementToInsert; 
   
         }
         
         System.out.println(Arrays.toString(testArray));

    }
}
