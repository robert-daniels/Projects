package UnmanagedWork.exam2prep.AlgoPractice;
import java.util.*;


/**
 * BubbleSort algo: named because larger values "bubble up" the array indexes.
 * When max value hits end of unsorted array, it becomes the lowest index of sorted
 * 
 * Can improve this by 
 * 1) checking if no swaps occurred, then stop
 * 2) treat the array as sorted / unsorted. When the largest value has hit the end of the unsorted
 * array, the maxIndex for unsorted array is reduced by one. 
 * 
 * #TODO: O(N^2) complexity since it compares all values all times
 */


public class BubbleSort {

    public static void main(String[] args){

        int[] testArray = {5, 4, 3, 2, 1};

        for (int i = 0; i < testArray.length - 1; ++i){
            for (int j = 0; j < testArray.length - i - 1; ++j){
                if ( testArray[j] > testArray[j + 1]){
                    swapTwo(testArray, j, j+1);
                }
            }
        }

        System.out.println(Arrays.toString(testArray));
    }

    /**
     * Swaps the elements at the two passed indexes in the array
     * 
     * @param passedArray reference as int[]
     * @param index1
     * @param index2
     */

    public static void swapTwo(int[] passedArray, int index1, int index2){
        int holdingValue = 0;
        
        holdingValue = passedArray[index1];
        passedArray[index1] = passedArray[index2];
        passedArray[index2] = holdingValue;

    }
    
}
