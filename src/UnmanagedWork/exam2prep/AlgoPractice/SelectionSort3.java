package UnmanagedWork.exam2prep.AlgoPractice;

import java.util.*;

/**
 * More practice
 * 
 */
public class SelectionSort3 {

    public static void main(String[] args){
        
        int[] testArr = {5, 4, 3, 2, 1};
        SwapTwo swapper = new SwapTwo();
        int minIndex = 0;

        for (int i = 0; i < testArr.length; ++i){
            minIndex = i;
            for (int j = i; j < testArr.length; ++j){
                if (testArr[j] < testArr[minIndex]){
                    minIndex = j;
                }
            }

            swapper.swapTwo(testArr, i, minIndex);
        }

        System.out.println(Arrays.toString(testArr));
    }
}
