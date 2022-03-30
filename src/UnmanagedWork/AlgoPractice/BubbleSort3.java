package UnmanagedWork.AlgoPractice;

import java.util.*;


/**
 * Next Day Practice
 */

public class BubbleSort3 {
    
    public static void main(String[] args){

        int[] testArr = {5, 4, 3, 2, 1};

        SwapTwo swapper = new SwapTwo();

        for (int i = 0; i < testArr.length; ++i){
            for (int j = 1; j < testArr.length - i; ++j){
                if (testArr[i] > testArr[j]){
                    swapper.swapTwo(testArr, i, j);
                }
            }
        }

        System.out.println(Arrays.toString(testArr));
    }

}
