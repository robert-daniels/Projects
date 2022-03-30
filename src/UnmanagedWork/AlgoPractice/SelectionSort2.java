package UnmanagedWork.AlgoPractice;

import java.util.*;


/**
 * Next day practice
 */

public class SelectionSort2 {
    
    public static void main(String[] args){

        SwapTwo swapper = new SwapTwo();

        int[] testArr = {5, 4, 3, 2, 1};
        int minIndex;

        for (int i = 0; i < testArr.length; ++i){
            minIndex = i;
            for (int j = i; j < testArr.length; ++j){
                if ( testArr[j] < testArr[minIndex]){
                    minIndex = j;
                }
            }

            swapper.swapTwo(testArr, i, minIndex);
        }

        System.out.println(Arrays.toString(testArr));

    } 
}
