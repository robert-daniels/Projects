package UnmanagedWork.exam2prep.AlgoPractice;

import java.util.*;

/**
 * Insertion Sort: goes through each element in the unsorted portion of the array and inserts
 * it into its correct position in the sorted portion of the array. 
 * 
 */

public class InsertionSort {
    
    public static void main(String[] args){

        int[] testArr = {5, 4, 3, 2, 1};
        SwapTwo swapper = new SwapTwo();
        int j;

        for (int i = 1; i < testArr.length; ++i){
           j = i;
           while (j > 0 && testArr[j] < testArr[j - 1]){
               swapper.swapTwo(testArr, j, j-1);
               --j; // VERY IMPORTANT! Protip: Don't forget this step.
           }
           
        }

        System.out.println(Arrays.toString(testArr));

    }

}
