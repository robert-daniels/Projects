import java.util.*;

public class SelectionSort {
    /**
     * Selection Sort Algorithm:
     * 
     * In-place Algorithm
     * O(n2) time complexity - quadratic
     * Doesn't require as much swapping as bubble sort
     * Unstable Algorithm // TODO in theory, if comparison is >=, the relative position should be preserved? 
     * 
     * Theory: array is partitioned into unsorted and sorted sections. 
     * Set maxNumber = array[0], traverse entire unsorted array to find maxNumber
     * Make note of index of maxNumber while doing this. 
     * 
     * At end of unsorted array, swap the number at the last index of unsorted with the 
     * value at the index of maxNumber. Decrement the index of the unsorted partition.  
     */

     
    public static void main(String[] args){
        
        int[] testArray = {20, 35, -15, 7, 55, 1, -22}; // perfect sized array
        int maxIndex;
        int tempSwapHold;
        int unsortedIndex = testArray.length - 1; // at start, consider all of the array unsorted

        while (unsortedIndex != 0){
            maxIndex = 0;

            for (int i = 0; i <= unsortedIndex; ++i){
                if ( testArray[i] >= testArray[maxIndex] ){ // TODO this may convert this into a stable sort 
                    maxIndex = i;
                } 
            }

            tempSwapHold = testArray[unsortedIndex]; 
            testArray[unsortedIndex] = testArray[maxIndex];
            testArray[maxIndex] = tempSwapHold;

            --unsortedIndex;

        }

        System.out.println(Arrays.toString(testArray));
           
    }
}
