package UnmanagedWork.AlgoPractice;

import java.util.*;

/**
 * Yes, more practice
 */

public class BubbleSort4 {
    
    public static void main(String[] args){

        int[] testArr = {5, 4, 3, 2, 1};
        SwapTwo swapper = new SwapTwo();

        for (int i = 0; i < testArr.length; ++i){
            for (int j = 0; j < testArr.length - i - 1; ++j){
                if (testArr[j] > testArr[j + 1]){
                    swapper.swapTwo(testArr, j, j + 1);
                }
            }
        }

        System.out.println(Arrays.toString(testArr));
    }
}
