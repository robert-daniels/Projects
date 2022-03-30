package UnmanagedWork.AlgoPractice;

import java.util.*;

/**
 * Repeat practice on BubbleSort
 */

public class BubbleSort2 {

    public static void main(String[] args){
        SwapTwo swapper = new SwapTwo();
        int[] testArray = {5, 4, 3, 2, 1};

        for (int i = 0; i < testArray.length - 1; ++i){
            for (int j = 0; j < testArray.length - i - 1; ++j){
                if ( testArray[j] > testArray[j + 1]){
                    swapper.swapTwo(testArray, j, j+1);
                }
            }
        }

        System.out.println(Arrays.toString(testArray));
    }
    
}
