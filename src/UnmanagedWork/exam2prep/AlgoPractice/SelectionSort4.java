package UnmanagedWork.exam2prep.AlgoPractice;

import java.util.*;

/**
 * More practice
 */
public class SelectionSort4 {
    
    public static void main(String[] args){

        SwapTwo swapper = new SwapTwo();
        int[] testArray = swapper.makeArray(7);
        int minIndex = 0;

        for (int i = 0; i < testArray.length; ++i){
            minIndex = i; // dont forget this is inside the control loop
            for (int j = i; j < testArray.length; ++j){
                if (testArray[j] < testArray[minIndex]){
                    minIndex = j;
                }

                swapper.swapTwo(testArray, i, minIndex);
            }
        }

        System.out.println(Arrays.toString(testArray));

    }
}
