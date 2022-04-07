package UnmanagedWork.exam2prep.AlgoPractice;

import java.util.*;


/**
 * Selection Sort: 
 * Aptly named, theres a sorted and unsorted portion of the array.
 * Crawl through the unsorted array looking for the minimum value
 * swap the min value with the value currently at lowest index of unsorted. 
 * 
 * Repeat until end of array
 * 
 * 
 * #TODO: O(N**2)
 */

public class SelectionSort {
    
    public static void main(String[] args){
        SwapTwo swapper = new SwapTwo();

        int[] testArray = {5, 4, 3, 2, 1};
        int minIndex;
       
        for (int i = 0; i < testArray.length; ++i){
            minIndex = i;

            for (int j = i + 1; j < testArray.length; ++j){
                if (testArray[j] < testArray[minIndex]){ // swap this for descending
                    minIndex = j;
                }
            }
            
            swapper.swapTwo(testArray, i, minIndex);
        }


        System.out.println(Arrays.toString(testArray));

        }

        

}
