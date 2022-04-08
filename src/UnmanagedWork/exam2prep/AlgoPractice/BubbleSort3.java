package UnmanagedWork.exam2prep.AlgoPractice;

import java.util.*;


/**
 * Next Day Practice
 */

public class BubbleSort3 {
    
    public static void main(String[] args){

        int[] testArr = {5, 4, 3, 2, 1};

        SwapTwo swapper = new SwapTwo();

        for (int i = 0; i < testArr.length - 1; ++i){
            for (int j = 1; j < testArr.length - i - 1; ++j){
                if (testArr[j] > testArr[j + 1]){
                    swapper.swapTwo(testArr, j, j + 1);
                }
            }
        }

        System.out.println(Arrays.toString(testArr));
    }

}
