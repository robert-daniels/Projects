package Udemy_Algo;

import java.util.*;

public class BubbleSort {
    
    public static void main(String[] args) {
        /**
         * Bubble Sort Algorithm
         * 
         * In-place Algorithm
         * O(n2) time complexity - Quadratic
         * Stable Algorithm unless comparison is >= 
         * 
         * Bubble sort degrades rapidly
         * Compare array[i] to array[i+1], if greater, swap values 
         * The larger values "bubble up."
         * 
         * Stable sort unless comparison is >= 
         * 
         */

         int testArray[] = {3, 1, 4, 6, 7, -9};

         int swapHold;
         int sortedIndex  = testArray.length;

        
         while (sortedIndex != 0){
             for (int i = 0; i < sortedIndex - 1; ++i){  // not clean
                 if (testArray[i] > testArray[i+1]){
                     swapHold = testArray[i];
                     testArray[i] = testArray[i+1];
                     testArray[i+1] = swapHold;
                 }
             }
             --sortedIndex;
         }

         System.out.println(Arrays.toString(testArray));

    }
}
